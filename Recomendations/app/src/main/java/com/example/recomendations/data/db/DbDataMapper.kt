package com.example.recomendations.data.db

import com.example.recomendations.model.CityModel
import com.example.recomendations.model.PlaceModel
import com.example.recomendations.model.WeatherModel

object DbDataMapper {
    fun convertToDomain(city: City): CityModel {
        with(city) {
            val places = city.places.map { convertPlaceToDomain(it) }
            val weather = city.weather.map { convertWeatherToDomain(it) }
            return CityModel(_id, name, latitude, longitude, places, weather)
        }
    }

    private fun convertPlaceToDomain(place: Place): PlaceModel {
        with(place) {
            return PlaceModel(name, address, rating, latitude, longitude)
        }
    }

    private fun convertWeatherToDomain(weather: Weather): WeatherModel {
        with(weather) {
            return WeatherModel(temperature, humidity, description)
        }
    }

    fun convertFromDomain(cityModel: CityModel): City {
        with(cityModel) {
            val places = cityModel.places.map { convertPlaceFromDomain(it) }
            val weather = cityModel.weather.map { convertWeatherFromDomain(it) }
            return City(id, name, latitude, longitude, places, weather)
        }
    }

    private fun convertPlaceFromDomain(placeModel: PlaceModel): Place {
        with(placeModel) {
            return Place(name, address, rating, latitude, longitude)
        }
    }

    private fun convertWeatherFromDomain(weatherModel: WeatherModel): Weather {
        with(weatherModel) {
            return Weather(temperature, humidity, description)
        }
    }

}