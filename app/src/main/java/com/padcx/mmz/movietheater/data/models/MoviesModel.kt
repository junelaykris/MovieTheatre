package com.padcx.mmz.movietheater.data.models

import androidx.lifecycle.LiveData
import com.padcx.mmz.movietheater.data.vos.*

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
interface MoviesModel {
    fun getAllPopularMovies(onError: (String) -> Unit) : LiveData<List<PopularMovieVO>>

    fun getAllMoviesFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getAllGenres(onError: (String) -> Unit) : LiveData<List<GenreVO>>

    fun getAllDiscoverListFromApiandSaveToDatabase(genericname: String,onSuccess: (List<PopularMovieVO>) -> Unit, onError: (String) -> Unit)

    fun getAllTopRatedList(onError: (String) -> Unit) : LiveData<List<TopRateMovieVO>>

    fun getAllActorList(onError: (String) -> Unit) : LiveData<List<ActorVO>>

    fun getMovieDetailFromApiAndSaveToDatabase(movieId: Int, onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getMovieDetailById(movieId: Int,onError: (String) -> Unit) : LiveData<MovieDetailVO>


  /*  fun getAllNowPlayingList(onError: (String) -> Unit) : LiveData<List<TopRateMovieVO>>*/

    fun getVideoIdByMovieId(movieId: Int,onSuccess: (List<VideoVO>) -> Unit,onError: (String) -> Unit)


    fun getAllNowplayingList(onSuccess: (List<TopRateMovieVO>) -> Unit, onError: (String) -> Unit)



    /* fun getAllCrewAndCastFromApiAndSaveToDatabase(movieId: Int,onSuccess: () -> Unit, onError: (String) -> Unit)

     fun getAllCrewList(onError: (String) -> Unit) : LiveData<List<CreaterVO>>
     fun getAllCastList(onError: (String) -> Unit) : LiveData<List<CastVO>>
 */



}