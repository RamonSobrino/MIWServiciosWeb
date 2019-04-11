package com.example.recomendations.data.db

class City(map: MutableMap<String, Any?>, var places: List<Place>, var weather: List<Weather>) {
    val _id: Long by map
    val name: String by map
    val latitude: Double by map
    val longitude: Double by map

    constructor(_id: Long, name: String, latitude: Double, longitude: Double, places: List<Place>, weather: List<Weather>) : this(
        mutableMapOf<String, Any?>(
            "_id" to _id,
            "name" to name,
            "latitude" to latitude,
            "longitude" to longitude
        ), places, weather
    )
}

class Place(map: MutableMap<String, Any?>) {
    val _id: Long by map
    val name: String by map
    val address: String by map
    val rating: Double by map
    val latitude: Double by map
    val longitude: Double by map

    constructor(name: String, address: String, rating: Double, latitude: Double, longitude: Double) : this(
        mutableMapOf(
            "name" to name,
            "address" to address,
            "rating" to rating,
            "latitude" to latitude,
            "longitude" to longitude
        )
    )
}


class Weather(map: MutableMap<String, Any?>) {
    val _id: Long by map
    val description: String by map
    val temperature: Double by map
    val humidity: Int by map

    constructor(temperature: Double, humidity: Int, description: String) : this(
        mutableMapOf(
            "temperature" to temperature,
            "humidity" to humidity,
            "description" to description
        )
    )
}