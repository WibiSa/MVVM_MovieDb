package com.rajadesain.mvvmmoviedb.detail_movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rajadesain.mvvmmoviedb.R

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailMovieViewModel
    private lateinit var detailMovieViewModel: DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
    }

//    private fun getViewModel(movieId: Int) : DetailMovieViewModel {
//        return ViewModelProvider.of(this, object : ViewModelProvider.factory{
//            override fun
//        })
//    }
}