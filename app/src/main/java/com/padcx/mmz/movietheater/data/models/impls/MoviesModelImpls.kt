package com.padcx.mmz.movietheater.data.models.impls

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.padcx.mmz.movietheater.BuildConfig
import com.padcx.mmz.movietheater.data.models.BaseModel
import com.padcx.mmz.movietheater.data.models.MoviesModel
import com.padcx.mmz.movietheater.data.vos.*
import com.padcx.mmz.movietheater.utils.EM_NO_INTERNET_CONNECTION
import com.padcx.mmz.movietheater.utils.PARAM_CREDITS
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
object MoviesModelImpls : BaseModel(), MoviesModel {

    override fun getAllPopularMovies(onError: (String) -> Unit): LiveData<List<PopularMovieVO>> {
        return mTheDB.moviesDao().getAllPopularMovie()
    }

    override fun getAllMoviesFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getPopularMovieList(BuildConfig.MOVIE_APIKEY)
            .map { it.dataResults?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                var popularList: List<PopularMovieVO> = listOf()
                popularList = it.map { it.copy(popular = 1) }.toList()
                mTheDB.moviesDao().insertAllPopularMovies(popularList)

                /*  val popularList = it.map { it.popular = 1 }.toList()
                  mTheDB.moviesDao().insertAllPopularMovies(popularList)
  */
                /*   val popularList = it.map { it.popular = 1 }.toList()
                   mTheDB.moviesDao().insertAllPopularMovies(popularList)*/
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })


        mMovieApi.getGENREList(BuildConfig.MOVIE_APIKEY)
            .map { it.genres?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.moviesDao().insertAllGenre(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })


        mMovieApi.getTopRatedMovies(BuildConfig.MOVIE_APIKEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.moviesDao().insertAllTopratedList(it as List<TopRateMovieVO>)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })

        mMovieApi.getActorList(BuildConfig.MOVIE_APIKEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.moviesDao().insertAllActors(it as List<ActorVO>)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })


    }


    override fun getAllDiscoverListFromApiandSaveToDatabase(
        genericname: String,
        onSuccess: (List<PopularMovieVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getDiscoverList(BuildConfig.MOVIE_APIKEY, genericname)
            .map { it.dataResults?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
/*
                var discoverList: List<PopularMovieVO> = listOf()
                discoverList = it.map { it.copy(genre = 1) }.toList()
                mTheDB.moviesDao().insertAllPopularMovies(discoverList)*/

                it?.let { movies ->
                    onSuccess(movies)
                }

                //mTheDB.moviesDao().insertAllDiscoverList(it as List<DiscoverVO>)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })

        /* mMovieApi.getDiscoverList(PARAM_API_KEY_VALUE, genericname)
             .map { it.results?.toList() ?: listOf() }
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe({
                 mTheDB.moviesDao().insertAllDiscoverList(it as List<DiscoverVO>)
             }, {
                 onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
             })*/
    }


    override fun getAllGenres(onError: (String) -> Unit): LiveData<List<GenreVO>> {
        return mTheDB.moviesDao().getAllGenre()
    }

    override fun getAllTopRatedList(onError: (String) -> Unit): LiveData<List<TopRateMovieVO>> {
        return mTheDB.moviesDao().getAllTopRatedMovie()
    }

    override fun getAllActorList(onError: (String) -> Unit): LiveData<List<ActorVO>> {
        return mTheDB.moviesDao().getAllActors()
    }

    override fun getMovieDetailFromApiAndSaveToDatabase(
        movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getMovieDetailById(movieId, BuildConfig.MOVIE_APIKEY, PARAM_CREDITS)
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.moviesDao().insertMovieDetailData(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getMovieDetailById(
        movieId: Int,
        onError: (String) -> Unit
    ): LiveData<MovieDetailVO> {
        return mTheDB.moviesDao().getAllMovieDetail(movieId)
    }

  /*  override fun getAllNowPlayingList(onError: (String) -> Unit): LiveData<List<TopRateMovieVO>> {
        return mTheDB.moviesDao().getAllTopRatedMovie()
    }
*/
    override fun getVideoIdByMovieId(
        movieId: Int,
        onSuccess: (List<VideoVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getVideoIdByMovieId(movieId,BuildConfig.MOVIE_APIKEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                it.let {
                    onSuccess(it as List<VideoVO>)
                }
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")
    override fun getAllNowplayingList(
        onSuccess: (List<TopRateMovieVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getNowPlayingMovies(BuildConfig.MOVIE_APIKEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                it.let {
                    onSuccess(it as List<TopRateMovieVO>)
                }
               // mTheDB.moviesDao().insertAllTopratedList(it as List<TopRateMovieVO>)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })

    }

    /* override fun getAllCrewAndCastFromApiAndSaveToDatabase(
         movieId: Int,
         onSuccess: () -> Unit,
         onError: (String) -> Unit
     ) {*/
    /*  mMovieApi.getMovieDetailByActorsAndCreator(movieId,PARAM_API_KEY_VALUE)
      .map { it.cast?.toList() ?: listOf() }
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
              mTheDB.moviesDao().insertCastData(it)
          }, {
              onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
          })*/


    /* mMovieApi.getMovieDetailByActorsAndCreator(movieId,PARAM_API_KEY_VALUE)
         .map { it.cast?.toList() ?: listOf() }
         .subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe({
             mTheDB.moviesDao().insertCastData(it)
         }, {
             onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
         })

     mMovieApi.getMovieDetailByActorsAndCreator(movieId,PARAM_API_KEY_VALUE)
         .map { it.crew?.toList() ?: listOf() }
         .subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe({
             mTheDB.moviesDao().insertCrewData(it)
         }, {
             onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
         })*/
}

/*    override fun getAllCrewList(onError: (String) -> Unit): LiveData<List<CreaterVO>> {
        return mTheDB.moviesDao()
            .getAllCrewList()
    }

    override fun getAllCastList(onError: (String) -> Unit): LiveData<List<CastVO>> {
        return mTheDB.moviesDao()
            .getAllCastList()
    }*/
