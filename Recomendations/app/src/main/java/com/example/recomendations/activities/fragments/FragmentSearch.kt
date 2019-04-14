package com.example.recomendations.activities.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recomendations.R

class FragmentSearch : Fragment() {

    interface OnSearchFragmentInteractionListener {
        fun onSearchComplete()
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

    private fun initialize() {

    }

}