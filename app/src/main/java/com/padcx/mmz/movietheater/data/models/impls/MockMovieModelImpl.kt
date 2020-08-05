package com.padcx.mmz.movietheater.data.models.impls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.padcx.mmz.movietheater.data.models.MoviesModel
import com.padcx.mmz.movietheater.data.vos.*
import com.padcx.mmz.movietheater.dummy.*

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
object MockMovieModelImpl : MoviesModel {
    var popularmovielist: MutableList<PopularMovieVO> = arrayListOf()
    var mpopularmovielist = MutableLiveData<List<PopularMovieVO>>()

    override fun getAllPopularMovies(onError: (String) -> Unit): LiveData<List<PopularMovieVO>> {
        val populardata = MutableLiveData<List<PopularMovieVO>>()
        populardata.postValue(getDummyPopularMovieList())
        return populardata
    }

    override fun getAllMoviesFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getAllGenres(onError: (String) -> Unit): LiveData<List<GenreVO>> {
        val liveData = MutableLiveData<List<GenreVO>>()
        liveData.postValue(getDummyGenre())
        return liveData
    }

    override fun getAllDiscoverListFromApiandSaveToDatabase(
        genericname: String,
        onSuccess: (List<PopularMovieVO>) -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getAllTopRatedList(onError: (String) -> Unit): LiveData<List<TopRateMovieVO>> {
        val liveData = MutableLiveData<List<TopRateMovieVO>>()
        liveData.postValue(getDummyTopRatedMovieList())
        return liveData
    }

    override fun getAllActorList(onError: (String) -> Unit): LiveData<List<ActorVO>> {
        val liveData = MutableLiveData<List<ActorVO>>()
        liveData.postValue(getDummyPopularActor())
        return liveData
    }

    override fun getMovieDetailFromApiAndSaveToDatabase(
        movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getMovieDetailById(
        movieId: Int,
        onError: (String) -> Unit
    ): LiveData<MovieDetailVO> {
        val liveData = MutableLiveData<MovieDetailVO>()
        liveData.postValue(getDummyMovieDetail())
        return liveData
    }

    override fun getAllNowPlayingList(onError: (String) -> Unit): LiveData<List<TopRateMovieVO>> {
        val liveData = MutableLiveData<List<TopRateMovieVO>>()
        liveData.postValue(getDummyTopRatedMovieList())
        return liveData
    }

    override fun getVideoIdByMovieId(
        movieId: Int,
        onSuccess: (List<VideoVO>) -> Unit,
        onError: (String) -> Unit
    ) {

    }
}