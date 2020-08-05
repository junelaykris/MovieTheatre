package com.padcx.mmz.movietheater.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.movietheater.data.models.MoviesModel
import com.padcx.mmz.movietheater.data.models.impls.MoviesModelImpls
import com.padcx.mmz.movietheater.data.vos.MovieDetailVO
import com.padcx.mmz.movietheater.mvp.views.VideoView

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
class VideoPresenterImpl : VideoPresenter, AbstractBasePresenter<VideoView>() {
    var mMoviesModel: MoviesModel = MoviesModelImpls

    override fun onUiReady(lifeCycleOwner: LifecycleOwner, movie_id: Int) {
        loadAllVideoFromAPI(movie_id)
    }
    private fun loadAllVideoFromAPI(movie_id: Int) {
        mMoviesModel.getVideoIdByMovieId(
            movie_id,
            onSuccess = {
                mView?.displayVideo(list = it)
            },
            onError = {}
        )
    }
}