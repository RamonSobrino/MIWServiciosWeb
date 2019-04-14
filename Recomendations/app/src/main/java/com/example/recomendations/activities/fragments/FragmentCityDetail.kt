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
import com.example.recomendations.model.CityModel
import kotlinx.android.synthetic.main.fragment_cities.*
import kotlinx.android.synthetic.main.fragment_city_detail.*
import java.io.Serializable

class FragmentCityDetail : Fragment() {

    companion object {
        private const val ARG_CITY = "FragmentCityDetail:city"

        fun newInstance(city: CityModel?): FragmentCityDetail {
            val fragemt = FragmentCityDetail()
            val args = Bundle()
            args.putSerializable(ARG_CITY, city as Serializable)
            fragemt.arguments = args
            return fragemt
        }
    }

    interface OnCityDetailFragmentInteractionListener {
    }

    private lateinit var listener: OnCityDetailFragmentInteractionListener
    private lateinit var city: CityModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
            R.layout.fragment_city_detail
            , container
            , false
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCityDetailFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context debe implementar OnCityDetailFragmentInteractionListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(arguments!!) {
            city = getSerializable(FragmentCityDetail.ARG_CITY) as CityModel
        }
        initialize()
    }

    private fun initialize() {
        places_list.layoutManager = LinearLayoutManager(context)
        places_list.adapter = PlaceAdapter(city.places) { }
    }

}