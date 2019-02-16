package ws.recomendation.places.webservices.services;

import java.util.List;

import ws.recomendation.places.webservices.Request;
import ws.recomendation.places.webservices.model.Recomendation;

public interface RecomendationService {

    List<Recomendation> execute(Request request);
    
}
