package com.example.recomendations.data.db

import com.example.recomendations.data.datasources.FavouriteDataSource
import com.example.recomendations.model.CityModel
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class FavouriteDb : FavouriteDataSource {

    private val favouritesDbHelper: FavouritesDbHelper = FavouritesDbHelper.instance

    override fun getAllFavourites(): List<CityModel> = favouritesDbHelper.use {
        select(CityTable.TABLE_NAME).parseList(object : MapRowParser<City> {
            override fun parseRow(columns: Map<String, Any?>) = City(columns.toMutableMap(), listOf(), listOf())
        }).map {
            val places = select(PlaceTable.TABLE_NAME)
                .whereSimple("${PlaceTable.CITY_ID} = ?", it._id.toString())
                .parseList(object : MapRowParser<Place> {
                    override fun parseRow(columns: Map<String, Any?>) = Place(columns.toMutableMap())
                })
            val weather = select(WeatherTable.TABLE_NAME)
                .whereSimple("${WeatherTable.CITY_ID} = ?", it._id.toString())
                .parseList(object : MapRowParser<Weather> {
                    override fun parseRow(columns: Map<String, Any?>) = Weather(columns.toMutableMap())
                })
            it.places = places
            it.weather = weather
            DbDataMapper.convertToDomain(it)
        }
    }

    override fun getFavouriteByCityId(cityId: Long): CityModel? = favouritesDbHelper.use {
        val city = select(CityTable.TABLE_NAME)
            .whereSimple("${CityTable.ID} = ?", cityId.toString())
            .parseOpt(object : MapRowParser<City> {
                override fun parseRow(columns: Map<String, Any?>) = City(columns.toMutableMap(), listOf(), listOf())
            })
        if (city != null) {
            DbDataMapper.convertToDomain(city)
        } else {
            null
        }
    }

    override fun saveFavourite(cityModel: CityModel) = favouritesDbHelper.use {
            deleteFavourite(cityModel)
            insertFavourite(cityModel)
    }

    private fun deleteFavourite(cityModel: CityModel) = favouritesDbHelper.use {
        with(DbDataMapper.convertFromDomain(cityModel)) {
            places.forEach {
                delete(PlaceTable.TABLE_NAME, "${PlaceTable.CITY_ID} = {cityId}", "cityId" to _id)
            }
            weather.forEach {
                delete(WeatherTable.TABLE_NAME, "${WeatherTable.CITY_ID} = {cityId}", "cityId" to _id)
            }
            delete(CityTable.TABLE_NAME, "${CityTable.ID} = {id}", "id" to _id)
        }
    }

    private fun insertFavourite(cityModel: CityModel) = favouritesDbHelper.use {
        with(DbDataMapper.convertFromDomain(cityModel)) {
            insert(
                CityTable.TABLE_NAME,
                CityTable.ID to _id,
                CityTable.NAME to name,
                CityTable.LATITUDE to latitude,
                CityTable.LONGITUDE to longitude
            )
            places.forEach {
                insert(
                    PlaceTable.TABLE_NAME,
                    PlaceTable.CITY_ID to _id,
                    PlaceTable.NAME to it.name,
                    PlaceTable.ADDRESS to it.address,
                    PlaceTable.RATING to it.rating,
                    PlaceTable.LATITUDE to it.latitude,
                    PlaceTable.LONGITUDE to it.longitude
                )
            }
            weather.forEach {
                insert(
                    WeatherTable.TABLE_NAME,
                    WeatherTable.CITY_ID to _id,
                    WeatherTable.DESCRIPTION to it.description,
                    WeatherTable.HUMIDITY to it.humidity,
                    WeatherTable.TEMPERATURE to it.temperature
                )
            }
        }
    }
}