package com.example.recomendations.activities.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recomendations.R
import com.example.recomendations.data.server.RecomendationServer
import com.example.recomendations.model.CityModel
import kotlinx.android.synthetic.main.fragment_search.*

class FragmentSearch : Fragment() {

    interface OnSearchFragmentInteractionListener {
        fun onSearchComplete(respuesta: List<CityModel>?)
    }

    private lateinit var listener: OnSearchFragmentInteractionListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
            R.layout.fragment_search
            , container
            , false
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSearchFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context debe implementar OnSearchFragmentInteractionListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initialize()
    }

    var list_of_items = arrayOf("Albacete","Alicante","Almería","Ávila","Badajoz","Barcelona","Bilbao","Burgos",
        "Cáceres","Cádiz","Castellón","Ciudad Real","Córdoba","A Coruña","Cuenca","Gerona","Granada","Guadalajara",
        "Huelva","Huesca","Jaén","León","Lérida","Logroño","Lugo","Madrid","Málaga","Murcia","Orense","Oviedo","Palencia",
        "Pamplona","Pontevedra","Salamanca","San Sebastian","Santander","Segovia","Sevilla","Soria","Tarragona","Teruel",
        "Toledo","Valencia","Valladolid","Vitoria","Zamora","Zaragoza")


    private fun initialize() {
        search_button.setOnClickListener { onSubmit() }
    }
    private fun onSubmit() {
        val ciudad =  spinnerCity.selectedItem.toString()
        val tipo = spinnerReconType.selectedItem.toString()

        val indiceCiudades = list_of_items.indexOf(ciudad)+1

        val respuesta = RecomendationServer().requestRecomendationByCityIdAndType(indiceCiudades, tipo)

        listener.onSearchComplete(respuesta)

    }

}