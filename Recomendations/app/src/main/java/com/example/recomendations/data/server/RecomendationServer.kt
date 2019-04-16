package com.example.recomendations.data.server

import com.example.recomendations.model.CityModel
import java.net.URL
import com.google.gson.Gson


class RecomendationServer {

    companion object {
        private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private const val API_URL = "http://156.35.95.51:8082/WS.Recomendation/restws/rs/?originCityId="
        private const val RECOMENDATION_TYPE = "&recomendationType="
    }

     fun requestRecomendationByCityIdAndType(cityId: Int, type: String): List<CityModel>? {
        val direcc = "$API_URL$cityId$RECOMENDATION_TYPE$type"
        val forecastJsonStr = URL(direcc).readText()
        val result = Gson().fromJson(forecastJsonStr, CityResult::class.java)
        return ServerDataMapper.convertToDomain(result)
    }
}