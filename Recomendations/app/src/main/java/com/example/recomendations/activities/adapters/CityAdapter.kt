package com.example.recomendations.activities.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.recomendations.R
import com.example.recomendations.model.CityModel
import kotlinx.android.synthetic.main.card_city.view.*

class CityAdapter(
    val cities: List<CityModel>,
    val isFavourite: Boolean,
    val selectedClick: (CityModel) -> Unit) :
    RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    class ViewHolder(val cardView: CardView, val itemClick: (CityModel) -> Unit) : RecyclerView.ViewHolder(cardView) {

        fun bindCity(city: CityModel, isFavourite: Boolean) {
            with(city) {
                itemView.btn_add_favourite.isEnabled = !isFavourite
                itemView.card_city_txt_name.text = name
                itemView.card_city_txt_recomendations.text = places.size.toString()
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_city, parent, false) as CardView
        return ViewHolder(view, selectedClick)
    }

    override fun getItemCount() = cities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCity(cities[position], isFavourite)
    }

}