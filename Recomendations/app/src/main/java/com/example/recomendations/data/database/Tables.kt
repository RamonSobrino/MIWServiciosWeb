package com.example.recomendations.data.database

class CityTable {
    companion object {
        const val TABLE_NAME = "city"
        const val ID = "id"
        const val NAME = "name"
        const val LATITUDE = "latitude"
        const val LONGITUDE = "longitude"
    }
}

class PlaceTable {
    companion object {
        const val TABLE_NAME = "place"
        const val ID = "id"
        const val NAME = "name"
        const val ADDRESS = "address"
        const val RATING = "rating"
        const val ratingNAME = "rating"
        const val LATITUDE = "latitude"
        const val LONGITUDE = "longitude"
    }
}

class WeatherTable {
    companion object {
        const val TABLE_NAME = "weather"
        const val ID = "id"
        const val TEMPERATURE = "temperature"
        const val HUMIDITY = "humidity"
        const val DESCRIPTION = "description"
    }
}