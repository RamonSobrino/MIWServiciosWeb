package com.example.recomendations.activities.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recomendations.R
import com.example.recomendations.model.CityModel
import com.example.recomendations.model.PlaceModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.Serializable

class FragmentCityMap : SupportMapFragment(), OnMapReadyCallback {

    companion object {
        private const val ARG_CITY = "FragmentCityMap:city"

        fun newInstance(city: CityModel?): FragmentCityMap {
            val fragemt = FragmentCityMap()
            val args = Bundle()
            args.putSerializable(ARG_CITY, city as Serializable)
            fragemt.arguments = args
            return fragemt
        }
    }

    interface OnCityMapFragmentInteractionListener {
    }

    private lateinit var listener: OnCityMapFragmentInteractionListener
    private lateinit var city: CityModel
    private lateinit var mMap: GoogleMap

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
            R.layout.fragment_city_map
            , container
            , false
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCityMapFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context debe implementar OnCityMapFragmentInteractionListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(arguments!!) {
            city = getSerializable(FragmentCityMap.ARG_CITY) as CityModel
        }
        initialize()
    }

    private fun initialize() {
        getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val markCity = createMark(city.latitude, city.longitude, city.name)
        mMap.addMarker(markCity)

        city.places.map { createMark(it.latitude, it.longitude, it.name) }
            .forEach { mMap.addMarker(it) }
    }

    private fun createMark(lat: Double, log: Double, name: String): MarkerOptions {
        val latLong = LatLng(lat, log)
        return MarkerOptions().position(latLong).title(name)
    }

}