package com.example.seccion_07_drawer_recycler_card.models

interface RecyclerFlightListener {

    fun onClick(flight: Flight, position: Int)
    fun onDelete(flight: Flight, position: Int)
}