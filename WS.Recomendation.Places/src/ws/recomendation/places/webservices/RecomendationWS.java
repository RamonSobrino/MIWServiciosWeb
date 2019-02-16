package ws.recomendation.places.webservices;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.jws.WebService;

import ws.recomendation.places.webservices.model.Recomendation;
import ws.recomendation.places.webservices.services.RecomendationServiceBuilder;
import ws.recomendation.places.webservices.services.RecomendationServiceType;

@WebService(
	endpointInterface = "ws.recomendation.places.webservices.IRecomendationWS")
public class RecomendationWS implements IRecomendationWS {

    private final RecomendationServiceBuilder builder = new RecomendationServiceBuilder();

    @Override
    public Recomendation[] find(Request request) {
	List<Recomendation> recomendations = builder
		.build(getServicesType())
		.parallelStream()
		.flatMap(s -> s.execute(request).stream())
		.collect(Collectors.toList());
	return recomendations.toArray(new Recomendation[recomendations.size()]);
    }

    private List<RecomendationServiceType> getServicesType() {
	return Arrays
		.asList(new RecomendationServiceType[] {
			RecomendationServiceType.GOOGLE_PLACES });
    }

}
