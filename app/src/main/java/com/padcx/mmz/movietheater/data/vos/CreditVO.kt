package com.padcx.mmz.movietheater.data.vos

import androidx.room.Entity
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcx.mmz.movietheater.persistance.typeconverters.CreditTypeConverter
import com.padcx.mmz.movietheater.persistance.typeconverters.GenreIdListTypeConverter

/**
 * Created by Myint Myint Zaw on 8/4/2020.
 */

@TypeConverters(CreditTypeConverter::class)
data class CreditVO(
    @SerializedName("cast") val cast: ArrayList<CastVO>?=ArrayList(),
    @SerializedName("crew") val crew: ArrayList<CreaterVO>? = ArrayList()
) {
}