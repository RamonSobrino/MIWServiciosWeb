package com.example.recomendations.model

data class CityModel(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val places: List<PlaceModel>,
    val weather: List<WeatherModel>
)

data class PlaceModel(val name: String, val address: String, val rating: Double, val latitude: Double, val longitude: Double)

data class WeatherModel(val temperature: Double, val humidity: Int, val description: String)