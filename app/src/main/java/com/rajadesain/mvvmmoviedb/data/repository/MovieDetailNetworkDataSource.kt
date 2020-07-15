package com.rajadesain.mvvmmoviedb.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rajadesain.mvvmmoviedb.data.api.TheMovieDbInterface
import com.rajadesain.mvvmmoviedb.data.valueobject.MovieDetail
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class MovieDetailNetworkDataSource (private val apiService : TheMovieDbInterface,  private val compositeDisposable: CompositeDisposable) {

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState

    private val _downloadedMovieDetailResponse = MutableLiveData<MovieDetail>()
    val downloadMovieDetailResponse: LiveData<MovieDetail>
        get() = _downloadedMovieDetailResponse

    fun fetchMovieDetail(movieId: Int){

        _networkState.postValue(NetworkState.LOADING)

        try {
            compositeDisposable.add(
                apiService.getMovieDetail(movieId)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadedMovieDetailResponse.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("MovieDetailDataSource", it.message.toString())
                        }
                    )
            )
        }
        catch (e: Exception){
            Log.e("MovieDetailDataSource", e.message.toString())
        }
    }
}