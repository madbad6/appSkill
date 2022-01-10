package com.madbad.myapp.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.madbad.myapp.model.Film
import kotlinx.android.synthetic.main.film_item.view.*

class FilmViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.title
    private val poster = itemView.poster
    private val description = itemView.description

    fun bind(film: Film) {
        title.text = film.title
        poster.setImageResource(film.poster)
        description.text = film.description
    }
}