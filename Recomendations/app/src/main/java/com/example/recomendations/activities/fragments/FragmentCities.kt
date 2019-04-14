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
import com.example.recomendations.data.db.FavouriteDb
import com.example.recomendations.model.CityModel
import kotlinx.android.synthetic.main.fragment_cities.*
import java.io.Serializable

class FragmentCities : Fragment() {

    companion object {
        private const val ARG_CITIES = "FragmentCities:cities"

        fun newInstance(cities: List<CityModel>?): FragmentCities {
            val fragemt = FragmentCities()
            val args = Bundle()
            if (cities != null) {
                args.putSerializable(ARG_CITIES, cities as Serializable)
            } else {
                args.putSerializable(ARG_CITIES, null)
            }
            fragemt.arguments = args
            return fragemt
        }
    }

    interface OnCitiesFragmentInteractionListener {
        fun onCitySelected(city: CityModel)
    }

    private lateinit var listener: OnCitiesFragmentInteractionListener
    private lateinit var cities: List<CityModel>
    private val favouriteDb: FavouriteDb = FavouriteDb()
    private var isFavourite = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cities, container, false)
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
            cities = when (getSerializable(ARG_CITIES)) {
                null -> {
                    isFavourite = true
                    favouriteDb.getAllFavourites()
                }
                else -> {
                    isFavourite = false
                    getSerializable(ARG_CITIES) as List<CityModel>
                }
            }
        }
        initialize()
    }

    private fun initialize() {
        cities_list.layoutManager = LinearLayoutManager(context)
        cities_list.adapter = CityAdapter(cities, isFavourite) {
            listener.onCitySelected(it)
        }
    }

}