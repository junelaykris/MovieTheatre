package com.padcx.mmz.movietheater.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.padcx.mmz.movietheater.data.vos.PopularMovieVO
import com.padcx.mmz.movietheater.dummy.getDummyPopularMovieList
import com.padcx.mmz.movietheater.persistance.daos.MovieDao
import com.padcx.mmz.movietheater.persistance.db.MoviesDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {
    private lateinit var movieDao: MovieDao
    private lateinit var moviedb: MoviesDB

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        moviedb = Room.inMemoryDatabaseBuilder(
            context, MoviesDB::class.java
        ).build()
        movieDao = moviedb.moviesDao()
    }

    @After
    fun closeDb() {
        moviedb.close()
    }

    @Test
    fun insertIntoDatabaseTest() {
        val populardata: PopularMovieVO = getDummyMovie()
        movieDao.insertPopularMovieData(populardata)
        assert(movieDao.findBurgerById(populardata.id).value?.id == populardata.id)
    }

    companion object {

        fun getDummyMovie(): PopularMovieVO {

            val arr1 = ArrayList<Int>()
            arr1.add(35)
            arr1.add(10749)
            val movieOne = PopularMovieVO(
                1,
                120.0,
                "/mb7wQv0adK3kjOUr9n93mANHhPJ.jpg",
                false,
                "With college decisions looming, Elle juggles her long-distance romance with Noah, changing relationship with bestie Lee and feelings for a new classmate.",
                "2020-07-24",
                arr1,
                "The Kissing Booth 2",
                "en",
                "The Kissing Booth 2",
                "/wO5QSWZPBT71gMLvrRex0bVc0V9.jpg"
            )
            return movieOne
        }

    }


}