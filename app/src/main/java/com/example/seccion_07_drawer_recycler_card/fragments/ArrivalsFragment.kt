package com.example.seccion_07_drawer_recycler_card.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seccion_07_drawer_recycler_card.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ArrivalsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle(R.string.arrivals_fragment_title)
        return inflater.inflate(R.layout.fragment_arrivals, container, false)
    }


}
