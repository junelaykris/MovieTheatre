package com.padcx.mmz.movietheater.data.models

import android.content.Context
import com.padcx.mmz.movietheater.network.MovieApi
import com.padcx.mmz.movietheater.persistance.db.MoviesDB
import com.padcx.mmz.movietheater.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */

abstract class BaseModel {
    lateinit var mMovieApi : MovieApi
    lateinit var mTheDB: MoviesDB
    init {

        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mMovieApi = retrofit.create(MovieApi::class.java)
    }
    fun initDatabase(context: Context){
        mTheDB = MoviesDB.getDBInstance(context)
    }
}