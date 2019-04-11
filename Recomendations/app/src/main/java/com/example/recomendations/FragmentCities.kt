package com.example.recomendations

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recomendations.data.db.FavouriteDb
import com.example.recomendations.data.db.FavouritesDbHelper
import com.example.recomendations.model.CityModel
import com.example.recomendations.model.PlaceModel
import com.example.recomendations.model.WeatherModel
import kotlinx.android.synthetic.main.fragment_cities.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class FragmentCities : Fragment() {

    companion object {
        private const val ARG_CITIES = "FragmentCities:cities"

        fun newInstance(cities: ArrayList<City>): FragmentCities {
            val fragemt = FragmentCities()
            val args = Bundle()
            args.putSerializable(ARG_CITIES, cities)
            fragemt.arguments = args
            return fragemt
        }
    }

    interface OnCitiesFragmentInteractionListener {
    }

    private lateinit var listener: OnCitiesFragmentInteractionListener
    private lateinit var cities: ArrayList<City>


    override fun onCreateView(
        inflater: LayoutInflater
        , container: ViewGroup?
        , savedInstanceState: Bundle?
    )
            : View? {
        return inflater.inflate(
            R.layout.fragment_cities
            , container
            , false
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCitiesFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context debe implementar OnCitiesFragmentInteractionListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(arguments!!) {
            cities = getSerializable(ARG_CITIES) as ArrayList<City>
        }
        initialize()
    }

    private fun initialize() {
        cities_list.layoutManager = LinearLayoutManager(context)
        cities_list.adapter = CityAdapter(cities) { }

        var favourites = FavouriteDb().getAllFavourites()
        Log.d("FAVS", favourites.toString())

        val cityModel1 = CityModel(
            1,
            "Oviedo",
            43.36029,
            -5.84476,
            listOf(PlaceModel("Suchi Go", "Calle de Campomanes, 6, 33008 Oviedo, Asturias", 4.2, 43.359003, -5.845461)),
            listOf(WeatherModel(15.0, 80, "Rain"))
        )
        FavouriteDb().saveFavourite(cityModel1)
        favourites = FavouriteDb().getAllFavourites()
        Log.d("FAVS", favourites.toString())
        val cityModel2 = CityModel(2, "Madrid", 40.416775, -3.703790, listOf(), listOf(WeatherModel(15.0, 80, "Rain")))
        FavouriteDb().saveFavourite(cityModel2)
        favourites = FavouriteDb().getAllFavourites()
        Log.d("FAVS", favourites.toString())
        val cityModelUpdate = favourites[0].copy(weather = listOf(WeatherModel(15.0, 80, "Rain")))
        favourites = FavouriteDb().getAllFavourites()
        Log.d("FAVS", favourites.toString())
    }

}