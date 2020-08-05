package com.padcx.mmz.movietheater.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcx.mmz.movietheater.persistance.typeconverters.GenreIdListTypeConverter

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
@Entity(tableName = "movies")
@TypeConverters(GenreIdListTypeConverter::class)
data class PopularMovieVO(
    @PrimaryKey
    @SerializedName("id") var id: Int = 0,

    @SerializedName("popularity") var popularity: Double = 0.0,

    @SerializedName("poster_path") var posterPath: String = "",

    @SerializedName("adult") var adult: Boolean = false,

    @SerializedName("overview") var overview: String = "",

    @SerializedName("release_date") var release_date: String = "",

    @SerializedName("genre_ids") var genre_ids: ArrayList<Int> = ArrayList(),

    @SerializedName("original_title") var original_title: String = "",

    @SerializedName("original_language") var original_language: String = "",

    @SerializedName("title") var title: String = "",

    @SerializedName("backdrop_path") var backdrop_path: String = "",

    @SerializedName("vote_count") var vote_count: Long = 0,

    @SerializedName("video") var video: Boolean = false,

    @SerializedName("vote_average") var vote_average: Double = 0.0,

    var popular: Int = 0,
    var genre: Int = 0
) {

    /*  fun isResponseOk():Boolean{
          return data.isEmpty() && code == CODE_RESPONSE
      }*/

}