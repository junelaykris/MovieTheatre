package com.padcx.mmz.movietheater.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
data class VideoVO(
    @SerializedName("id")  val id: String,
    @SerializedName("iso_3166_1") val iso_3166_1: String,
    @SerializedName("iso_639_1")val iso_639_1: String,
    @SerializedName("key") val key: String,
    @SerializedName("name") val name: String,
    @SerializedName("site")  val site: String,
    @SerializedName("size")  val size: Int,
    @SerializedName("type") val type: String
) {
}