package com.example.recomendations.model

import java.io.Serializable

data class CityModel(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val places: List<PlaceModel>,
    val weather: List<WeatherModel>
) : Serializable

data class PlaceModel(
    val name: String,
    val address: String,
    val rating: Double,
    val latitude: Double,
    val longitude: Double
) : Serializable

data class WeatherModel(
    val temperature: Double,
    val humidity: Int,
    val description: String
) : Serializable