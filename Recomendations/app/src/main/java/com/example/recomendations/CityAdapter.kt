package com.example.recomendations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_city.view.*

class CityAdapter(val cities: List<City>, val itemClick: (City) -> Unit) :
    RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    class ViewHolder(val cardView: CardView, val itemClick
    : (City) -> Unit) : RecyclerView.ViewHolder(cardView) {

        fun bindCity(city: City) {
            with(city) {
                itemView.card_city_txt_name.text = name
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_city, parent, false) as CardView
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount() = cities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCity(cities[position])
    }

}