package com.padcx.mmz.movietheater.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcx.mmz.movietheater.persistance.typeconverters.CreditTypeConverter
import com.padcx.mmz.movietheater.persistance.typeconverters.GenreIdListTypeConverter

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
@Entity(tableName = "movie_detail")
@TypeConverters(CreditTypeConverter::class)
data class MovieDetailVO(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("adult")  val adult: Boolean,
    @SerializedName("budget")  val budget: Int,
    @SerializedName("homepage")  val homepage: String,
    @SerializedName("imdb_id")   val imdb_id: String,
    @SerializedName("original_language")  val original_language: String,
    @SerializedName("original_title") val original_title: String,
    @SerializedName("overview")val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("revenue") val revenue: Int,
    @SerializedName("runtime") val runtime: Int,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String,
    @SerializedName("title") val title: String,
    @SerializedName("video")  val video: Boolean,
    @SerializedName("vote_average")  val vote_average: Double,
    @SerializedName("vote_count")  val vote_count: Int,
    @SerializedName("credits")  val credits: CreditVO= CreditVO()
) {
}