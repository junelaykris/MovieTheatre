package com.padcx.mmz.movietheater.responses

import com.google.gson.annotations.SerializedName
import com.padcx.mmz.movietheater.data.vos.ActorVO

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
data class GetActorResponse(
    @SerializedName("results")  val results: ArrayList<ActorVO?>? = ArrayList()
)