package com.padcx.mmz.movietheater.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcx.mmz.movietheater.data.vos.CreditVO

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
class CreditTypeConverter {
    @TypeConverter
    fun toString(genreList: CreditVO): String {
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun toCreditList(creditTypeJsonStr: String): CreditVO {
        val creditType = object : TypeToken<CreditVO>() {}.type
        return Gson().fromJson(creditTypeJsonStr, creditType)
    }
}