package com.example.recomendations.data.db

import android.database.sqlite.SQLiteDatabase
import com.example.recomendations.App
import org.jetbrains.anko.db.*

class FavouritesDbHelper :
    ManagedSQLiteOpenHelper(
        App.instance,
        DB_NAME, null,
        DB_VERSION
    ) {

    companion object {
        const val DB_NAME = "favourites.db"
        const val DB_VERSION = 1
        val instance by lazy { FavouritesDbHelper() }
    }

    override fun onCreate(db: SQLiteDatabase) {
        initTables(db)
//        initMockData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.dropTable(PlaceTable.TABLE_NAME, true)
        db.dropTable(WeatherTable.TABLE_NAME, true)
        db.dropTable(CityTable.TABLE_NAME, true)
        onCreate(db)
    }

    private fun initTables(db: SQLiteDatabase) {
        db.createTable(
            CityTable.TABLE_NAME, true,
            CityTable.ID to INTEGER + PRIMARY_KEY,
            CityTable.NAME to TEXT,
            CityTable.LATITUDE to REAL,
            CityTable.LONGITUDE to REAL
        )
        db.createTable(
            PlaceTable.TABLE_NAME, true,
            PlaceTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            PlaceTable.CITY_ID to INTEGER,
            PlaceTable.NAME to TEXT,
            PlaceTable.ADDRESS to TEXT,
            PlaceTable.RATING to REAL,
            PlaceTable.LATITUDE to REAL,
            PlaceTable.LONGITUDE to REAL
        )
        db.createTable(
            WeatherTable.TABLE_NAME, true,
            WeatherTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            WeatherTable.CITY_ID to INTEGER,
            WeatherTable.DESCRIPTION to TEXT,
            WeatherTable.TEMPERATURE to REAL,
            WeatherTable.HUMIDITY to INTEGER
        )
    }

    private fun initMockData(db: SQLiteDatabase) {
        db.insert(
            CityTable.TABLE_NAME,
            CityTable.ID to 1,
            CityTable.NAME to "Oviedo",
            CityTable.LATITUDE to 43.36029,
            CityTable.LONGITUDE to -5.84476
        )
        db.insert(
            CityTable.TABLE_NAME,
            CityTable.ID to 2,
            CityTable.NAME to "Madrid",
            CityTable.LATITUDE to 40.416775,
            CityTable.LONGITUDE to -3.703790
        )
        db.insert(
            PlaceTable.TABLE_NAME,
            PlaceTable.CITY_ID to 1,
            PlaceTable.NAME to "Sushi Go",
            PlaceTable.ADDRESS to "Calle de Campomanes, 6, 33008 Oviedo, Asturias",
            PlaceTable.RATING to 4.2,
            PlaceTable.LATITUDE to 43.359003,
            PlaceTable.LONGITUDE to -5.845461
        )
        db.insert(WeatherTable.TABLE_NAME,
            WeatherTable.CITY_ID to 1,
            WeatherTable.DESCRIPTION to "Rain",
            WeatherTable.HUMIDITY to 80,
            WeatherTable.TEMPERATURE to 15.0
        )
    }
}