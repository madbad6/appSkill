package com.madbad.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madbad.myapp.model.Film
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        initStartNewFilm()

    }

    fun initStartNewFilm(){

        val film = intent.extras?.get("film") as Film

        details_toolbar.title = film.title
        details_poster.setImageResource(film.poster)
        details_description.text = film.description
    }
}