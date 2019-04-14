package com.example.recomendations.activities.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recomendations.R
import com.example.recomendations.activities.adapters.CityAdapter
import com.example.recomendations.activities.adapters.PlaceAdapter
import com.example.recomendations.activities.adapters.WeatherAdapter
import com.example.recomendations.model.CityModel
import com.example.recomendations.model.WeatherModel
import kotlinx.android.synthetic.main.fragment_cities.*
import kotlinx.android.synthetic.main.fragment_city_detail.*
import kotlinx.android.synthetic.main.fragment_city_weather.*
import java.io.Serializable

class FragmentCityWeather : Fragment() {

    companion object {
        private const val ARG_CITY = "FragmentCityWeather:city"

        fun newInstance(city: CityModel?): FragmentCityWeather {
            val fragemt = FragmentCityWeather()
            val args = Bundle()
            args.putSerializable(ARG_CITY, city as Serializable)
            fragemt.arguments = args
            return fragemt
        }
    }

    interface OnCityWeatherFragmentInteractionListener {
    }

    private lateinit var listener: OnCityWeatherFragmentInteractionListener
    private lateinit var weather: List<WeatherModel>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
            R.layout.fragment_city_weather
            , container
            , false
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCityWeatherFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context debe implementar OnCityWeatherFragmentInteractionListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(arguments!!) {
            val city = getSerializable(FragmentCityWeather.ARG_CITY) as CityModel
            weather = city.weather
        }
        initialize()
    }

    private fun initialize() {
        weather_list.layoutManager = LinearLayoutManager(context)
        weather_list.adapter = WeatherAdapter(weather) { }
    }

}