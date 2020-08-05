package com.padcx.mmz.movietheater.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
/*@Entity(tableName = "castactor")*/
data class CastVO(
   /* @PrimaryKey*/
    @SerializedName("id") val id: Int,
    @SerializedName("cast_id")  val cast_id: Int,
    @SerializedName("character")   val character: String,
    @SerializedName("credit_id")  val credit_id: String,
    @SerializedName("gender") val gender: Int,
    @SerializedName("name")  val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("profile_path") val profile_path: String?
)