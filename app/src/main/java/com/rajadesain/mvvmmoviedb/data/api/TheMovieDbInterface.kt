package com.rajadesain.mvvmmoviedb.data.api

import com.rajadesain.mvvmmoviedb.data.valueobject.MovieDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDbInterface {
    //link untuk popular movie page 1
    //https://api.themoviedb.org/3/movie/popular?api_key=a082cb211791fe299c31ee786011177e&page=1
    //link untuk detail movie
    //https://api.themoviedb.org/3/movie/475557?api_key=a082cb211791fe299c31ee786011177e
    //base link movieDb
    //https://api.themoviedb.org/3/

    //fungsi untuk get movie detail
    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id")id: Int) : Single<MovieDetail>

}