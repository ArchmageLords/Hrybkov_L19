package com.example.hrybkov_l19

import android.os.Bundle
import android.transition.Fade
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.hrybkov_l19.databinding.DetailInfoActivityBinding

class DetailInfoActivity : AppCompatActivity() {

    private lateinit var binding: DetailInfoActivityBinding


    companion object {
        const val FILM_KEY = "FILM_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(window) {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            exitTransition = Fade()
            enterTransition = Fade()
        }
        setupBinding()
        setupInfo()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAfterTransition()
    }

    private fun setupBinding() {
        binding = DetailInfoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupInfo() {
        val film = intent.getParcelableExtra<Film>(FILM_KEY)
        binding.tvDetailInfoName.text = film?.name
        binding.tvDetailInfoYear.text = film?.year
        binding.tvDetailInfoRate.text = getString(R.string.rate, film?.rate)
        binding.tvDetailInfoCountry.text = getString(R.string.country, film?.country)
        binding.tvDetailInfoDescription.text = film?.description
        Glide.with(this)
            .load(film?.image)
            .error(R.mipmap.ic_launcher_round)
            .circleCrop()
            .into(binding.ivDetailInfo)
    }

}