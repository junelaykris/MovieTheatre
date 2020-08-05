package com.padcx.mmz.movietheater.responses

import com.google.gson.annotations.SerializedName
import com.padcx.mmz.movietheater.data.vos.PopularMovieVO

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
data class DiscoverResponse(
    @SerializedName("results")  val results: ArrayList<PopularMovieVO>? = ArrayList()
) {
}