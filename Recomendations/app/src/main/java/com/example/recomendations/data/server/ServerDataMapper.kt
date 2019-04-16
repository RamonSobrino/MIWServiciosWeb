package com.example.recomendations.data.server

import com.example.recomendations.model.CityModel
import com.example.recomendations.model.PlaceModel
import com.example.recomendations.model.WeatherModel


object ServerDataMapper {



    fun convertToDomain(list: CityResult): List<CityModel> {
        return list.list.map {  city ->
            convertCityItemToDomain(city)
        }
    }

    private fun convertCityItemToDomain(city: City): CityModel {
        return CityModel(
            id = city.cityId,
            name = city.cityName,
            latitude = city.latitude,
            longitude = city.longitude,
            places = city.places.map { place -> convertPlaceItemToDomain(place)},
            weather = city.weather5Days.map { weather -> convertWeatherToDomain(weather) }
        )
    }

    private fun convertWeatherToDomain(weather: Weather): WeatherModel {
        return WeatherModel(
            temperature = weather.Temperature,
            humidity = weather.Humidity,
            description = weather.Description
        )

    }

    private fun convertPlaceItemToDomain(place: Place): PlaceModel {
        return PlaceModel(
            name = place.name,
            address = place.address,
            latitude = place.lat,
            longitude = place.lng,
            rating = place.rating
        )
    }

}