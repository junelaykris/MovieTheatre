package com.padcx.mmz.movietheater.responses

import com.google.gson.annotations.SerializedName
import com.padcx.mmz.movietheater.data.vos.CastVO
import com.padcx.mmz.movietheater.data.vos.CreaterVO

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
data class GetActorAndCreatorResponse(
    @SerializedName("crew") val crew: ArrayList<CreaterVO?>? = ArrayList(),
    @SerializedName("cast") val cast: ArrayList<CastVO?>? = ArrayList()
)