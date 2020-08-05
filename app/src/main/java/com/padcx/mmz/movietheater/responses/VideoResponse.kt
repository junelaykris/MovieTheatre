package com.padcx.mmz.movietheater.responses

import com.google.gson.annotations.SerializedName
import com.padcx.mmz.movietheater.data.vos.VideoVO

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
class VideoResponse(
    @SerializedName("results")  val results: ArrayList<VideoVO>?= ArrayList()
)  {
}