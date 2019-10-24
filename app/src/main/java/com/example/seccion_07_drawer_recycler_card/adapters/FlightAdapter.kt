package com.example.seccion_07_drawer_recycler_card.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seccion_07_drawer_recycler_card.R
import com.example.seccion_07_drawer_recycler_card.inflate
import com.example.seccion_07_drawer_recycler_card.loadByResource
import com.example.seccion_07_drawer_recycler_card.models.Flight
import com.example.seccion_07_drawer_recycler_card.models.RecyclerFlightListener
import kotlinx.android.synthetic.main.nav_header.view.*
import kotlinx.android.synthetic.main.recycler_flight.view.*

class FlightAdapter(private val flights: List<Flight>,
                    private val listener: RecyclerFlightListener) :RecyclerView.Adapter<FlightAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.recycler_flight ))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(flights[position], listener)

    override fun getItemCount() = flights.size


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(flight: Flight, listener: RecyclerFlightListener) = with(itemView){
            textViewCityName.text = flight.city
            imageViewBg.loadByResource(flight.imgResource)
            // Clicks Events
            setOnClickListener { listener.onClick(flight, adapterPosition) }
            buttonDelete.setOnClickListener { listener.onDelete(flight, adapterPosition) }
        }
    }
}