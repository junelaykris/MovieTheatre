package com.padcx.mmz.movietheater.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
    fun showSnackbar(message : String) {
        Snackbar
            .make(window.decorView,message, Snackbar.LENGTH_LONG).show()
    }
}