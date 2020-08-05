package com.padcx.mmz.movietheater.responses

import com.google.gson.annotations.SerializedName
import com.padcx.mmz.movietheater.data.vos.PopularMovieVO

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
data class PopularMoviesResponse(
    @SerializedName("page") val code: Int = 0,
    @SerializedName("total_results") val total_results: Long = -1,
    @SerializedName("total_pages") val total_pages: Long = -1,
    @SerializedName("results") val dataResults: ArrayList<PopularMovieVO>? = ArrayList()
) {
}