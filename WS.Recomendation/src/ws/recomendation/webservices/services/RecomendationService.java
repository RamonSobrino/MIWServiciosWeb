package ws.recomendation.webservices.services;

import java.util.ArrayList;
import java.util.List;

import ws.recomendation.webservices.model.CityRecomendation;
import ws.recomendation.webservices.model.Place;
import ws.recomendation.webservices.services.cities.CitiesService;
import ws.recomendation.webservices.services.cities.CitiesServiceSoap;
import ws.recomendation.webservices.services.cities.City;
import ws.recomendation.webservices.services.places.Recomendation;
import ws.recomendation.webservices.services.places.RecomendationType;
import ws.recomendation.webservices.services.places.RecomendationWSService;
import ws.recomendation.webservices.services.places.Request;

public class RecomendationService {

	private final CitiesServiceSoap citiesService = new CitiesService().getCitiesServiceSoap();

	public Place parceRecomendation(Recomendation r) {
		return new Place(r.getPlace(), r.getAddress(), r.getRating());
	}

	public List<CityRecomendation> getRecommendations(int originCityId) {

		List<City> closeCities = citiesService.getClosestCitiesWithWeatcher(originCityId, 3).getCity();

		List<RecomendationType> types = new ArrayList<RecomendationType>();
		types.add(RecomendationType.MUSEUM);

		List<CityRecomendation> result = new ArrayList<CityRecomendation>();

		Request request = new Request();
		List<Recomendation> recomendations = new ArrayList<Recomendation>();
		for (City city : closeCities) {
			request = new Request();
			request.setLat(city.getLatitude());
			request.setLon(city.getLongitude());
			recomendations = new RecomendationWSService().getRecomendationWSPort().find(request);
			for (Recomendation r : recomendations) {
				CityRecomendation cityRecomendation = new CityRecomendation();
				cityRecomendation.setCity(city.getName());
				cityRecomendation.getPlaces().add(new Place(r.getPlace(), r.getAddress(), r.getRating()));
				result.add(cityRecomendation);
			}
		}

		return result;
	}

}
