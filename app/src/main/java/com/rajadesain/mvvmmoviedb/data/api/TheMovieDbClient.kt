package com.rajadesain.mvvmmoviedb.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//link untuk popular movie page 1
//https://api.themoviedb.org/3/movie/popular?api_key=a082cb211791fe299c31ee786011177e&page=1
//link untuk detail movie
//https://api.themoviedb.org/3/movie/475557?api_key=a082cb211791fe299c31ee786011177e
//base link movieDb
//https://api.themoviedb.org/3/

const val API_KEY = "a082cb211791fe299c31ee786011177e"
const val BASE_URL= "https://api.themoviedb.org/3/"
//
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

object TheMovieDbClient {

    fun getClient(): TheMovieDbInterface {

        val requestInterceptor = Interceptor{ chain ->

            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheMovieDbInterface::class.java)
    }
}