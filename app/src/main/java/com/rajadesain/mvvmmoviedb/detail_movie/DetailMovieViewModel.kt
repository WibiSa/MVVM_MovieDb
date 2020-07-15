package com.rajadesain.mvvmmoviedb.detail_movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rajadesain.mvvmmoviedb.data.repository.NetworkState
import com.rajadesain.mvvmmoviedb.data.valueobject.MovieDetail
import io.reactivex.disposables.CompositeDisposable

class DetailMovieViewModel(private val detailMovieRepository: DetailMovieRepository, movieId: Int): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val movieDetail: LiveData<MovieDetail> by lazy {
        detailMovieRepository.fetchMovieDetail(compositeDisposable, movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        detailMovieRepository.getMovieDetailNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}