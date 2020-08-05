package com.padcx.mmz.movietheater.persistance.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcx.mmz.movietheater.data.vos.*
import com.padcx.mmz.movietheater.persistance.daos.MovieDao

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
@Database(
    entities = [PopularMovieVO::class, GenreVO::class, DiscoverVO::class, TopRateMovieVO::class,
        ActorVO::class, MovieDetailVO::class], version = 7, exportSchema = false
)
abstract class MoviesDB : RoomDatabase() {
    companion object {
        val DB_NAME = "PADC_X_MOVIE.DB"
        var dbInstance: MoviesDB? = null

        fun getDBInstance(context: Context): MoviesDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MoviesDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun moviesDao(): MovieDao
}