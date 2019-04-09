package com.example.recomendations

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cities.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class FragmentCities : Fragment() {

    companion object {
        private const val ARG_CITIES="FragmentCities:cities"

        fun newInstance(cities: ArrayList <City>) : FragmentCities{
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
    private lateinit var cities: ArrayList <City>


    override fun onCreateView(
        inflater: LayoutInflater
        , container: ViewGroup?
        , savedInstanceState: Bundle?)
            : View? {
        return inflater.inflate(
            R.layout.fragment_cities
            , container
            , false)
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
    }

}