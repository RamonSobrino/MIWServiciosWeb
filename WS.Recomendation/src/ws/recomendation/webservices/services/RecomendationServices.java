package ws.recomendation.webservices.services;

import java.util.List;

import ws.recomendation.webservices.model.Place;
import ws.recomendation.webservices.services.places.RecomendationType;
import ws.recomendation.webservices.services.places.RecomendationWSService;
import ws.recomendation.webservices.services.places.Request;

public class RecomendationServices {

    public Place parceRecomendation(
	    ws.recomendation.webservices.services.places.Recomendation r) {
	return new Place(r.getPlace(), r.getAddress(), r.getRating());
    }

    public List<ws.recomendation.webservices.services.places.Recomendation>
	    getPlaces(double lat, double lon, List<RecomendationType> types) {
	// oviedo 43.3619145,-5.8493887
	Request request = new Request();
	request.setLat(43.3619145);
	request.setLon(-5.8493887);
	request.getTypes().addAll(types);
	return new RecomendationWSService()
		.getRecomendationWSPort()
		.find(request);
    }

}
