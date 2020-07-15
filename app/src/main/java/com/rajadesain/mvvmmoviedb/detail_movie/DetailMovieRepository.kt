package com.rajadesain.mvvmmoviedb.detail_movie

import androidx.lifecycle.LiveData
import com.rajadesain.mvvmmoviedb.data.api.TheMovieDbInterface
import com.rajadesain.mvvmmoviedb.data.repository.MovieDetailNetworkDataSource
import com.rajadesain.mvvmmoviedb.data.repository.NetworkState
import com.rajadesain.mvvmmoviedb.data.valueobject.MovieDetail
import io.reactivex.disposables.CompositeDisposable

class DetailMovieRepository(private val apiService : TheMovieDbInterface) {

    lateinit var movieDetailNetworkDataSource: MovieDetailNetworkDataSource

    fun fetchMovieDetail (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetail>{

        movieDetailNetworkDataSource = MovieDetailNetworkDataSource(apiService, compositeDisposable)
        movieDetailNetworkDataSource.fetchMovieDetail(movieId)

        return movieDetailNetworkDataSource.downloadMovieDetailResponse
    }

    fun getMovieDetailNetworkState(): LiveData<NetworkState>{
        return movieDetailNetworkDataSource.networkState
    }
}