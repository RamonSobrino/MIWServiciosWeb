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

	public List<CityRecomendation> getRecommendations(int originCityId, int numberOfCitiesToReturn,
			RecomendationType type) {

		if (numberOfCitiesToReturn == 0) {
			numberOfCitiesToReturn = 3;
		}

		List<City> closeCities = citiesService.getClosestCitiesWithWeatcher(originCityId, numberOfCitiesToReturn)
				.getCity();

		List<RecomendationType> types = new ArrayList<RecomendationType>();
		if (type != null) {			
			types.add(type);
		}

		List<CityRecomendation> result = new ArrayList<CityRecomendation>();

		List<Recomendation> recomendations = new ArrayList<Recomendation>();
		for (City city : closeCities) {
			CityRecomendation cityRecomendation = new CityRecomendation();
			cityRecomendation.setCityId(city.getId());
			cityRecomendation.setCityName(city.getName());
			cityRecomendation.setLatitude(city.getLatitude());
			cityRecomendation.setLongitude(city.getLongitude());
			cityRecomendation.setWeather5Days(city.getWeather5Days().getCityWeather());
			
			Request request = new Request();
			request.setLat(city.getLatitude());
			request.setLon(city.getLongitude());
			request.getTypes().addAll(types);
			recomendations = new RecomendationWSService().getRecomendationWSPort().find(request);
			for (Recomendation r : recomendations) {
				cityRecomendation.getPlaces().add(new Place(r.getPlace(), r.getAddress(), r.getRating()));
			}
			result.add(cityRecomendation);
		}

		return result;
	}

}
