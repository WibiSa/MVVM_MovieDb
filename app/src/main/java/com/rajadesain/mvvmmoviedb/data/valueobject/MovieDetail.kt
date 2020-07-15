package com.rajadesain.mvvmmoviedb.data.valueobject


import com.google.gson.annotations.SerializedName

data class MovieDetail(
    //pake anotasi jika ada nama variable yang dirubah ex: poster_path -> posterPath
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String
)