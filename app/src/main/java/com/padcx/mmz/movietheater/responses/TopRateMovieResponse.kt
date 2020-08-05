package com.padcx.mmz.movietheater.responses

import com.google.gson.annotations.SerializedName
import com.padcx.mmz.movietheater.data.vos.TopRateMovieVO

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
data class TopRateMovieResponse(
    @SerializedName("results")  val results: ArrayList<TopRateMovieVO?>? = ArrayList()
)
