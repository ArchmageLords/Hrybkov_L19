package com.example.hrybkov_l19


import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.toAndroidPair
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_items.view.*

class FilmRecyclerAdapter(private val listOfFilms: List<Film>) :
    RecyclerView.Adapter<FilmRecyclerAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_items, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(listOfFilms[position])
    }

    override fun getItemCount(): Int = listOfFilms.size

    inner class RecyclerViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        fun bind(film: Film) {
            itemView.tvRecycler.text =
                itemView.resources.getString(R.string.name_year, film.name, film.year)
            itemView.recyclerItems.setOnClickListener {
                val imagePair = Pair<View, String>(
                    it.ivRecycler,
                    it.resources.getString(R.string.transition_image)
                ).toAndroidPair()
                val namePair = Pair<View, String>(
                    it.tvRecycler,
                    it.resources.getString(R.string.transition_name)
                ).toAndroidPair()
                val activityTransition =
                    ActivityOptions.makeSceneTransitionAnimation(
                        it.context as Activity,
                        imagePair,
                        namePair
                    )
                val intent = Intent(it.context, DetailInfoActivity::class.java).apply {
                    putExtra("FILM_KEY", film)
                }
                it.context.startActivity(intent, activityTransition.toBundle())
            }
            Glide.with(itemView.context)
                .load(film.image)
                .error(R.mipmap.ic_launcher_round)
                .circleCrop()
                .into(itemView.ivRecycler)
        }
    }
}