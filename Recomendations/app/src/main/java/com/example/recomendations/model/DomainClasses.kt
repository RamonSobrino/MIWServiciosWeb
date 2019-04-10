package com.example.recomendations.model

data class CityRecommendations(
    val id: Int,
    val name: String,
    val latitude: Float,
    val longitude: Float,
    val places: List<Place>,
    val weather: List<Weather>
)

data class Place(val name: String, val address: String, val rating: Float, val latitude: Float, val longitude: Float)

data class Weather(val temperature: Float, val humidity: Int, val description: String)