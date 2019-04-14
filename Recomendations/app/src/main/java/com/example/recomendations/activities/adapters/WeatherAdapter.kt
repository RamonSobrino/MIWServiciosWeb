package com.example.recomendations.activities.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.recomendations.R
import com.example.recomendations.model.WeatherModel
import kotlinx.android.synthetic.main.card_weather.view.*

class WeatherAdapter(
    val weather: List<WeatherModel>,
    val selectedClick: (WeatherModel) -> Unit) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(val cardView: CardView, val itemClick: (WeatherModel) -> Unit) :
        RecyclerView.ViewHolder(cardView) {

        fun bindElement(element: WeatherModel) {
            with(element) {
                itemView.card_weather_txt_name.text = description
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_weather, parent, false) as CardView
        return ViewHolder(view, selectedClick)
    }

    override fun getItemCount() = weather.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindElement(weather[position])
    }
}