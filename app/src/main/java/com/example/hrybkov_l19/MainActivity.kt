package com.example.hrybkov_l19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hrybkov_l19.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupListeners()
        setupRecyclerView()
    }

    private fun setupListeners() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupRecyclerView() {
        binding.rvAnimation.adapter = FilmRecyclerAdapter(setupFilmList())
        binding.rvAnimation.layoutManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        binding.rvAnimation.addItemDecoration(
            DividerItemDecoration(
                applicationContext,
                RecyclerView.VERTICAL
            )
        )
    }

    private fun setupFilmList(): List<Film> {
        val first_film = Film(
            "Fight Club",
            "1999",
            "USA",
            "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.",
            88.40,
            "https://upload.wikimedia.org/wikipedia/uk/6/6d/Fight_Club_%D0%BF%D0%BB%D0%B0%D0%BA%D0%B0%D1%82.jpg"
        )
        val second_film = Film(
            "Schindler's List",
            "1993",
            "USA",
            getString(R.string.schindlers_list),
            89.20,
            "https://upload.wikimedia.org/wikipedia/uk/3/38/Schindler%27s_List_movie.jpg"
        )
        val third_film = Film(
            "12 Angry Men",
            "1957",
            "USA",
            "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.",
            90.22,
            "https://upload.wikimedia.org/wikipedia/ru/9/91/12_angry_men.jpg"
        )
        val fourth_film = Film(
            "The Dark Knight",
            "2008",
            "UK",
            getString(R.string.dark_knight),
            90.43,
            "https://upload.wikimedia.org/wikipedia/uk/8/8a/Dark_Knight.jpg"
        )
        val fifth_film = Film(
            "The Godfather",
            "1972",
            "USA",
            "An organized crime dynasty's aging patriarch transfers control of his clandestine empire to his reluctant son.",
            91.73,
            "https://upload.wikimedia.org/wikipedia/uk/1/15/The-godfather-p1-ukr.jpg"
        )
        val sixth_film = Film(
            "The Shawshank Redemption",
            "1994",
            "USA",
            getString(R.string.shawshank_redemption),
            95.84,
            "https://upload.wikimedia.org/wikipedia/uk/8/87/%D0%92%D1%82%D0%B5%D1%87%D0%B0_%D0%B7_%D0%A8%D0%BE%D1%83%D1%88%D0%B5%D0%BD%D0%BA%D0%B0.jpg"
        )
        return listOf(first_film, second_film, third_film, fourth_film, fifth_film, sixth_film)
    }
}