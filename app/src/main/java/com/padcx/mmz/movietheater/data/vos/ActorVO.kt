package com.padcx.mmz.movietheater.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
@Entity(tableName = "actors")
data class ActorVO(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("adult")val adult: Boolean,
    @SerializedName("gender") val gender: Int,
    @SerializedName("known_for_department") val known_for_department: String,
    @SerializedName("name")val name: String,
    @SerializedName("popularity")val popularity: Double,
    @SerializedName("profile_path") val profile_path: String
) {

}