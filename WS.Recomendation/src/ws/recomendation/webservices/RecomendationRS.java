package ws.recomendation.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ws.recomendation.webservices.model.Place;
import ws.recomendation.webservices.model.Recomendation;
import ws.recomendation.webservices.services.RecomendationServices;
import ws.recomendation.webservices.services.places.RecomendationType;

@Path("rs")
public class RecomendationRS {

    private final RecomendationServices services = new RecomendationServices();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recomendation> getRecomendations() {
	List<Recomendation> result = new ArrayList<Recomendation>();
	result.add(getOviedo());
	return result;
    }

    private Recomendation getOviedo() {
	Recomendation recomendation = new Recomendation();
	recomendation.setCity("Oviedo");

	List<RecomendationType> types = new ArrayList<RecomendationType>();
	types.add(RecomendationType.MUSEUM);
	services
		.getPlaces(43.3619145, -5.8493887, types)
		.stream()
		.map(this::parceRecomendation)
		.forEach(recomendation.getPlaces()::add);
	return recomendation;
    }

    private Place parceRecomendation(
	    ws.recomendation.webservices.services.places.Recomendation r) {
	return new Place(r.getPlace(), r.getAddress(), r.getRating());
    }

}
