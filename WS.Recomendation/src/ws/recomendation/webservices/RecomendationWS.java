package ws.recomendation.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ws.recomendation.webservices.model.Recomendation;
import ws.recomendation.webservices.services.RecomendationServices;
import ws.recomendation.webservices.services.places.RecomendationType;

@Path("rs")
public class RecomendationWS {

    private final RecomendationServices services = new RecomendationServices();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recomendation> getRecomendations() {
	List<Recomendation> result = new ArrayList<Recomendation>();
	result.add(getOviedo());
	return result;
    }

    public Recomendation getOviedo() {
	Recomendation recomendation = new Recomendation();
	recomendation.setCity("Oviedo");

	List<RecomendationType> types = new ArrayList<RecomendationType>();
	types.add(RecomendationType.MUSEUM);
	List<ws.recomendation.webservices.services.places.Recomendation> 
		places = services.getPlaces(43.3619145, -5.8493887, types);
	for (ws.recomendation.webservices.services.places.Recomendation p : places) {
	    recomendation.getPlaces().add(services.parceRecomendation(p));
	}
	return recomendation;
    }

}
