package com.example.recomendations.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recomendations.R
import com.example.recomendations.model.CityModel

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object {
        const val CITY = "MapsActivity:selected"
    }

    private lateinit var mMap: GoogleMap
    private lateinit var citySelected: CityModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        citySelected = intent.getSerializableExtra(MapsActivity.CITY) as CityModel
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val markCity = createMark(citySelected.latitude, citySelected.longitude, citySelected.name)

        mMap.addMarker(markCity)
        citySelected.places.map { createMark(it.latitude, it.longitude, it.name) }
            .forEach { mMap.addMarker(it) }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(markCity.position, 15.0f))
        mMap.uiSettings.isZoomControlsEnabled = true
    }

    private fun createMark(lat: Double, log: Double, name: String): MarkerOptions {
        val latLong = LatLng(lat, log)
        return MarkerOptions().position(latLong).title(name)
    }
}
