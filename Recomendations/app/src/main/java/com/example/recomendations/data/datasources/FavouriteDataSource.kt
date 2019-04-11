package com.example.recomendations.data.datasources

import com.example.recomendations.model.CityModel

interface FavouriteDataSource {
    fun getAllFavourites(): List<CityModel>
    fun getFavouriteByCityId(cityId: Long): CityModel?
    fun saveFavourite(cityModel: CityModel)
}