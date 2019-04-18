package com.example.recomendations.data.server

import com.example.recomendations.model.CityModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL


class RecomendationServer {

    companion object {
        private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private const val API_URL = "http://156.35.95.51:8082/WS.Recomendation/restws/rs/?"
        private const val RECOMENDATION_TYPE = "&recomendationType="
    }

    fun requestRecomendationByCityIdAndType(cityId: Int, type: String): List<CityModel>? {

        val direc2 = "http://156.35.95.51:8082/WS.Recomendation/restws/rs/"


        if(cityId ==0 && type == "ninguna"){
            val forecastJsonStr = URL(direc2)
            val texto = forecastJsonStr.readText()
            // val forecastJsonStr  : String = response.text
            val listType = object : TypeToken<List<City>>() { }.type
            val result = Gson().fromJson<List<City>>(texto, listType)
            val cR = CityResult(result)
            return ServerDataMapper.convertToDomain(cR)

        }else{
            var direcc = "$API_URL"
            if(cityId !=0) direcc+= "originCityId=$cityId"
            if(type != "ninguna") direcc+= "$RECOMENDATION_TYPE$type"

            val forecastJsonStr = URL(direcc)

            val texto = forecastJsonStr.readText()
            // val forecastJsonStr  : String = response.text
            val listType = object : TypeToken<List<City>>() { }.type
            val result = Gson().fromJson<List<City>>(texto, listType)
            val cR = CityResult(result)
            return ServerDataMapper.convertToDomain(cR)
        }



        //http://156.35.95.51:8082/WS.Recomendation/restws/rs/?originCityId=##&recomendationType=string
//        val response : Response = khttp.get(
//            url = "http://156.35.95.51:8082/WS.Recomendation/restws/rs/",
//            params = mapOf("originCityId" to cityId.toString(), "recomendationType" to type))
        //forecastJsonStr.openConnection()
        //val contenido = forecastJsonStr.content

    }
}