package com.padcx.mmz.movietheater.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
class GenreIdListTypeConverter {
    @TypeConverter
    fun toString(genreList: ArrayList<Integer>): String {
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun toCommentList(genreListListJsonStr: String): ArrayList<Integer> {
        val genereListType = object : TypeToken<ArrayList<Integer>>() {}.type
        return Gson().fromJson(genreListListJsonStr, genereListType)
    }
}