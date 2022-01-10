package com.madbad.myapp.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.madbad.myapp.R
import com.madbad.myapp.model.Film
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initStartNewFilm()
    }

    fun initStartNewFilm(){

        //but this is not accurate
//        val film = AppCompatActivity().intent.extras?.get("film") as Film

        val film = arguments?.get("film") as Film

        details_toolbar.title = film.title
        details_poster.setImageResource(film.poster)
        details_description.text = film.description
    }
}