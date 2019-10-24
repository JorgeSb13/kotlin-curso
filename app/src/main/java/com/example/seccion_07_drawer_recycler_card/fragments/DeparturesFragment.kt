package com.example.seccion_07_drawer_recycler_card.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.seccion_07_drawer_recycler_card.R
import com.example.seccion_07_drawer_recycler_card.adapters.FlightAdapter
import com.example.seccion_07_drawer_recycler_card.models.Flight
import com.example.seccion_07_drawer_recycler_card.models.RecyclerFlightListener
import com.example.seccion_07_drawer_recycler_card.toast
import kotlinx.android.synthetic.main.fragment_departures.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DeparturesFragment : Fragment() {

    private val list: ArrayList<Flight> by lazy { getFlights() }

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: FlightAdapter

    private val layoutManager by lazy { LinearLayoutManager(context) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity?.setTitle(R.string.departures_fragment_title)
        val rootView = inflater.inflate(R.layout.fragment_departures, container, false)

        recycler = rootView.recyclerView as RecyclerView
        setRecyclerView()
        return rootView
    }

    private fun setRecyclerView() {
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager
        adapter = (FlightAdapter(list, object : RecyclerFlightListener {
            override fun onClick(flight: Flight, position: Int) {
                activity?.toast("Let's go to ${flight.city}!")
            }

            override fun onDelete(flight: Flight, position: Int) {
                list.remove(flight)
                adapter.notifyItemRemoved(position)
                activity?.toast("${flight.city} has been removed!")
            }

        }))
        recycler.adapter = adapter
    }

    private fun getFlights() :ArrayList<Flight> {
        return object : ArrayList<Flight>() {
            init {
                add(Flight(1, "Seattle", R.drawable.seattle))
                add(Flight(2, "New York", R.drawable.new_york))
                add(Flight(3, "London", R.drawable.london))
                add(Flight(4, "Seville", R.drawable.seattle))
                add(Flight(5, "Venice", R.drawable.venice))
                add(Flight(6, "Athens", R.drawable.athens))
                add(Flight(7, "Toronto", R.drawable.toronto))
                add(Flight(8, "Dublin", R.drawable.dublin))
                add(Flight(9, "Caribbean", R.drawable.caribbean_sea))
            }
        }
    }

}
