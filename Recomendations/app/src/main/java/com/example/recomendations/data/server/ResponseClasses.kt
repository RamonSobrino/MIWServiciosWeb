package com.example.recomendations.data.server

import java.io.Serializable

data class CityResult(val list: List<City>)


data class City(
    val cityId: Long,
    val cityName: String,
    val latitude: Double,
    val longitude: Double,
    val places: List<Place>,
    val weather5Days: List<Weather>
) : Serializable

data class Place(
    val name: String,
    val address: String,
    val rating: Double,
    val lat: Double,
    val lng: Double
) : Serializable

data class Weather(
    val Temperature: Double,
    val Humidity: Int,
    val Description: String
) : Serializable