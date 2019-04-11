package com.example.recomendations.data.db

object CityTable {
    const val TABLE_NAME = "city"
    const val ID = "_id"
    const val NAME = "name"
    const val LATITUDE = "latitude"
    const val LONGITUDE = "longitude"
}

object PlaceTable {
    const val TABLE_NAME = "place"
    const val ID = "_id"
    const val CITY_ID = "city_id"
    const val NAME = "name"
    const val ADDRESS = "address"
    const val RATING = "rating"
    const val LATITUDE = "latitude"
    const val LONGITUDE = "longitude"
}

object WeatherTable {
    const val TABLE_NAME = "weather"
    const val ID = "_id"
    const val CITY_ID = "city_id"
    const val TEMPERATURE = "temperature"
    const val HUMIDITY = "humidity"
    const val DESCRIPTION = "description"
}