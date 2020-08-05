package com.padcx.mmz.movietheater.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
@Entity(tableName = "genres")
data class GenreVO(
    @PrimaryKey
    var id : Long = 0,
    var name : String = ""
) {

}