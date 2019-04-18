package com.example.recomendations.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.recomendations.activities.fragments.FragmentCities
import com.example.recomendations.activities.fragments.FragmentSearch
import com.example.recomendations.R
import com.example.recomendations.model.CityModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity()
    , FragmentCities.OnCitiesFragmentInteractionListener
    , FragmentSearch.OnSearchFragmentInteractionListener {

    override fun onCitySelected(city: CityModel) {
        startActivity<CityActivity>(
            CityActivity.CITY to city
        )
    }

    override fun onSearchComplete(respuesta: List<CityModel>?) {
        launchFragmentCities(respuesta)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)
    }

    private fun initialize() {
        setSupportActionBar(principal_toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_principal, principal_toolbar,
            R.string.drawer_close, R.string.drawer_open
        )
        drawer_principal.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true
        toggle.syncState()

        principal_navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.principal_menu_cities -> launchFragmentCities(null)
                R.id.principal_menu_search -> launchFragmentSearch()
            }
            drawer_principal.closeDrawers()
            true
        }
        launchFragmentSearch()
    }

    private fun launchFragmentSearch() {
        title = getString(R.string.recommendations)
        principal_navigation.setCheckedItem(R.id.principal_menu_search)
        launchFragment(FragmentSearch())
    }

    private fun launchFragmentCities(cities: List<CityModel>?) {
        title = getString(R.string.cities)
        principal_navigation.setCheckedItem(R.id.principal_menu_cities)
        launchFragment(FragmentCities.newInstance(cities))
    }

    private fun launchFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(principal_container.id, fragment)
        fragmentTransaction.commit()
    }
}
