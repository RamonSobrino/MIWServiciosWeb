package com.example.recomendations.data.database

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper
import org.jetbrains.anko.db.dropTable

class FavouritesDbHelper(): ManagedSQLiteOpenHelper(App.instance, FavouritesDbHelper.DB_NAME, null, FavouritesDbHelper.DB_VERSION){

    companion object {
        const val DB_NAME = "favourites.db"
        const val DB_VERSION = 1
        val instance by lazy { FavouritesDbHelper()}
    }

    override fun onCreate(db: SQLiteDatabase) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.dropTable(PlaceTable.TABLE_NAME, true)
        db.dropTable(WeatherTable.TABLE_NAME, true)
        db.dropTable(CityTable.TABLE_NAME, true)
        onCreate(db)
    }
}