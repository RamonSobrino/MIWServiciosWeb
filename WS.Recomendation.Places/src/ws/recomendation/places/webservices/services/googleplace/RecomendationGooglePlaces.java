package ws.recomendation.places.webservices.services.googleplace;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import ws.recomendation.places.webservices.Request;
import ws.recomendation.places.webservices.model.Recomendation;
import ws.recomendation.places.webservices.model.RecomendationType;
import ws.recomendation.places.webservices.services.RecomendationService;

public class RecomendationGooglePlaces implements RecomendationService {

    private static final String URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
    private static final String KEY_API = "AIzaSyBkHtuofALt_MdQrdiOCkLxm_HhJ_EEHJ4";

    @Override
    public List<Recomendation> execute(Request request) {
	MultivaluedMap<String, String> params = new MultivaluedMapImpl();
	params.add("type", getTypes(request.getTypes()));
	params.add("location", getLocation(request));
	params.add("radius", "1500");
	params.add("key", KEY_API);

	PlaceSearchResponse output = new Client()
		.resource(URL)
		.queryParams(params)
		.type(MediaType.APPLICATION_JSON)
		.get(ClientResponse.class)
		.getEntity(PlaceSearchResponse.class);

	List<Recomendation> recomendations = new ArrayList<Recomendation>();
	for (int i = 0; i < output.getResults().length; i++) {
	    PlaceResult place = output.getResults()[i];
	    Recomendation recomendation = new Recomendation();
	    recomendation.setPlace(place.getName());
	    recomendation.setAddress(place.getVicinity());
	    recomendation.setRating(place.getRating());
	    recomendations.add(recomendation);
	}
	return recomendations;
    }

    private String getLocation(Request request) {
	return new StringBuilder()
		.append(request.getLat())
		.append(",")
		.append(request.getLon())
		.toString();
    }

    private String getTypes(List<RecomendationType> types) {
	return types
		.stream()
		.flatMap(t -> getValueType(t).stream())
		.collect(Collectors.joining("%7C"));
    }

    private List<String> getValueType(RecomendationType type) {
	List<String> result = new ArrayList<String>();
	switch (type) {
	case MUSEUM:
	    result.add("museum");
	    break;
	case AQUARIUM:
	    result.add("aquarium");
	    break;
	case CASINO:
	    result.add("casino");
	    break;
	case NIGHT_CLUB:
	    result.add("night_club");
	    break;
	case PARK:
	    result.add("park");
	    break;
	case SPA:
	    result.add("spa");
	    break;
	}
	return result;
    }

}
