package ws.recomendation.places.webservices.services;

import java.util.List;
import java.util.stream.Collectors;

import ws.recomendation.places.webservices.services.googleplace.RecomendationGooglePlaces;

public class RecomendationServiceBuilder {

    public List<RecomendationService>
	    build(List<RecomendationServiceType> types) {
	return types
		.stream()
		.map(this::getService)
		.collect(Collectors.toList());
    }

    private RecomendationService getService(RecomendationServiceType type) {
	switch (type) {
	case GOOGLE_PLACES:
	    return new RecomendationGooglePlaces();
	default:
	    throw new RuntimeException("Service type unsuported " + type);
	}
    }

}
