package com.example.recomendations.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.recomendations.R
import com.example.recomendations.activities.fragments.FragmentCityDetail
import com.example.recomendations.activities.fragments.FragmentCityMap
import com.example.recomendations.activities.fragments.FragmentCityWeather
import com.example.recomendations.model.CityModel
import kotlinx.android.synthetic.main.activity_city.*

class CityActivity : AppCompatActivity()
    , FragmentCityDetail.OnCityDetailFragmentInteractionListener
    , FragmentCityMap.OnCityMapFragmentInteractionListener
    , FragmentCityWeather.OnCityWeatherFragmentInteractionListener {

    companion object {
        const val CITY = "CityActivity:selected"
    }

    private lateinit var citySelected: CityModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
        initialize()
    }

    private fun initialize() {
        citySelected = intent.getSerializableExtra(CITY) as CityModel

        setSupportActionBar(city_toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_city, city_toolbar,
            R.string.drawer_close, R.string.drawer_open
        )
        drawer_city.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true
        toggle.syncState()

        city_navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.city_menu_home -> launchFragmentHome()
                R.id.city_menu_map -> launchFragmentMap()
                R.id.city_menu_weather -> launchFragmentWeather()
            }
            drawer_city.closeDrawers()
            true
        }

        supportFragmentManager.beginTransaction().add(
            city_container.id,
            FragmentCityDetail.newInstance(citySelected)
        ).commit()
        city_navigation.setCheckedItem(R.id.city_menu_home)
    }

    private fun launchFragmentWeather() {
        city_navigation.setCheckedItem(R.id.city_menu_weather)
        launchFragment(FragmentCityWeather.newInstance(citySelected))
    }

    private fun launchFragmentMap() {
        city_navigation.setCheckedItem(R.id.city_menu_map)
        launchFragment(FragmentCityMap.newInstance(citySelected))
    }

    private fun launchFragmentHome() {
        city_navigation.setCheckedItem(R.id.city_menu_home)
        launchFragment(FragmentCityDetail.newInstance(citySelected))
    }

    private fun launchFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(city_container.id, fragment)
        fragmentTransaction.commit()
    }

}
