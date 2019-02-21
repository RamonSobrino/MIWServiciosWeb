package ws.recomendation.webservices.services;

import java.util.List;

import ws.recomendation.webservices.services.places.Recomendation;
import ws.recomendation.webservices.services.places.RecomendationType;
import ws.recomendation.webservices.services.places.RecomendationWSService;
import ws.recomendation.webservices.services.places.Request;

public class RecomendationServices {

    public List<Recomendation> getPlaces(double lat, double lon, 
	    List<RecomendationType> type) {
	//oviedo 43.3619145,-5.8493887
	Request request = new Request();
	request.setLat(43.3619145);
	request.setLon(-5.8493887);
	request.getTypes().add(RecomendationType.MUSEUM);
	return new RecomendationWSService()
		.getRecomendationWSPort()
		.find(request);
    }
    
}
