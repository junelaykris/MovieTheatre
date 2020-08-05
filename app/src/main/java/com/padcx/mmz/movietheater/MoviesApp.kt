package com.padcx.mmz.movietheater

import android.app.Application
import com.padcx.mmz.movietheater.data.models.impls.MoviesModelImpls

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
class MoviesApp:Application(){
    override fun onCreate() {
        super.onCreate()
        MoviesModelImpls.initDatabase(applicationContext)
    }
}