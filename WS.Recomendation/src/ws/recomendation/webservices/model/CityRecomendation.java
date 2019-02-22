package ws.recomendation.webservices.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import ws.recomendation.webservices.services.cities.CityWeather;

@XmlRootElement(name = "recomendation")
public class CityRecomendation {

	private Integer cityId;
	private String cityName;
	private Double latitude;
	private Double longitude;
	private List<Place> places = new ArrayList<Place>();
	private List<CityWeather> weather5Days = new ArrayList<>();

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public List<CityWeather> getWeather5Days() {
		return weather5Days;
	}

	public void setWeather5Days(List<CityWeather> weather5Days) {
		this.weather5Days = weather5Days;
	}

}
