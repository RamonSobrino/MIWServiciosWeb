package ws.recomendation.webservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ws.recomendation.webservices.model.CityRecomendation;
import ws.recomendation.webservices.services.RecomendationService;
import ws.recomendation.webservices.services.places.RecomendationType;

@Path("rs")
public class RecomendationWS {

	private final RecomendationService recomendationService = new RecomendationService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CityRecomendation> getRecomendations(@QueryParam("originCityId") int originCityId,
			@QueryParam("numberOfCitiesToReturn") int numberOfCitiesToReturn,
			@QueryParam("recomendationType") String recomendationType) {
		
		RecomendationType type = null;
		if (recomendationType != null) {			
			type = RecomendationType.fromValue(recomendationType);
		}
		
		return recomendationService.getRecommendations(originCityId, numberOfCitiesToReturn, type);
	}

}
