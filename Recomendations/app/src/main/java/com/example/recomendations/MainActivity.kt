package com.example.recomendations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.principal_header.*

val cities_db = arrayListOf<City>(
    City("Oviedo")
    ,City("Gijon")
    ,City("Aviles")
)

class MainActivity : AppCompatActivity()
    , FragmentCities.OnCitiesFragmentInteractionListener
    , FragmentSearch.OnSearchFragmentInteractionListener{

    override fun onSearchComplete() {
        launchFragmentCities(cities_db)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize() {
        setSupportActionBar(principal_toolbar)
        val toggle = ActionBarDrawerToggle(this, drawer, principal_toolbar,
            R.string.drawer_close, R.string.drawer_open)
        drawer.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true
        toggle.syncState()

        principal_navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.principal_menu_cities -> launchFragmentCities(cities_db)
                R.id.principal_menu_search -> launchFragmentSearch()
            }
            drawer.closeDrawers()
            true
        }

        supportFragmentManager.beginTransaction().add(principal_container.id, FragmentSearch()).commit()
        principal_navigation.setCheckedItem(R.id.principal_menu_search)
    }

    private fun launchFragmentSearch(){
        principal_navigation.setCheckedItem(R.id.principal_menu_search)
        launchFragment(FragmentSearch())
    }

    private fun launchFragmentCities(cities : ArrayList<City> = arrayListOf()){
        principal_navigation.setCheckedItem(R.id.principal_menu_cities)
        launchFragment(FragmentCities.newInstance(cities))
    }

    private fun launchFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(principal_container.id, fragment)
        fragmentTransaction.commit()
    }
}
