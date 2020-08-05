package com.padcx.mmz.movietheater.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
/*@Entity(tableName = "creator")*/
data class CreaterVO(
    /*  @PrimaryKey
      @SerializedName("id") val id: Int,*/
    @SerializedName("credit_id") val credit_id: String,
    @SerializedName("department") val department: String,
    @SerializedName("gender") val gender: Int,
    @SerializedName("job") val job: String,
    @SerializedName("name") val name: String,
    @SerializedName("profile_path") val profile_path: String?
)