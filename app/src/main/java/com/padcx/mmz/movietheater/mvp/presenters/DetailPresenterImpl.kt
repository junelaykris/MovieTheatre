package com.padcx.mmz.movietheater.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.mmz.movietheater.data.models.MoviesModel
import com.padcx.mmz.movietheater.data.models.impls.MoviesModelImpls
import com.padcx.mmz.movietheater.mvp.views.HomeView
import com.padcx.mmz.movietheater.mvp.views.MovieDetailView
import com.padcx.mmz.shared.AbstractBasePresenter

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<MovieDetailView>() {
    var mMovieModel:MoviesModel = MoviesModelImpls
    override fun onUiReady(lifeCycleOwner: LifecycleOwner, movieid: Int) {

        mMovieModel.getMovieDetailFromApiAndSaveToDatabase(
            movieId = movieid,
            onSuccess = {},
            onError = {}
        )

        mMovieModel.getMovieDetailById(
            movieid,
            onError = {})
            .observe(lifeCycleOwner, Observer {
                it?.let {
                    mView?.displayMovieDetail(it)
                }

            })

/*

        mMovieModel.getAllCrewAndCastFromApiAndSaveToDatabase(
            movieId = movieid,
            onSuccess = {},
            onError = {}
        )

        mMovieModel.getAllCastList(onError = {})
            .observe(lifeCycleOwner, Observer {
                mView?.displayCastList(it)
            })

        mMovieModel.getAllCrewList(onError = {})
            .observe(lifeCycleOwner, Observer {
                mView?.displayCrewList(it)
            })
*/

    }

    override fun onTap() {

    }

}