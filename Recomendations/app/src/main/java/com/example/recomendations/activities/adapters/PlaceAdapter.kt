package com.example.recomendations.activities.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.recomendations.R
import com.example.recomendations.model.PlaceModel
import kotlinx.android.synthetic.main.card_place.view.*

class PlaceAdapter(
    val places: List<PlaceModel>,
    val selectedClick: (PlaceModel) -> Unit) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    class ViewHolder(val cardView: CardView, val itemClick: (PlaceModel) -> Unit) :
        RecyclerView.ViewHolder(cardView) {

        fun bindPlace(element: PlaceModel) {
            with(element) {
                itemView.card_place_txt_name.text = name
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_place, parent, false) as CardView
        return ViewHolder(view, selectedClick)
    }

    override fun getItemCount() = places.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPlace(places[position])
    }
}