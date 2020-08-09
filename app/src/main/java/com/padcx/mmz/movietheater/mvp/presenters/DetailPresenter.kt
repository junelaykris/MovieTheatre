package com.padcx.mmz.movietheater.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.movietheater.data.vos.MovieDetailVO
import com.padcx.mmz.movietheater.delegate.MovieDetailDelegate
import com.padcx.mmz.movietheater.mvp.views.MovieDetailView
import com.padcx.mmz.shared.BasePresenter

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
interface DetailPresenter : BasePresenter<MovieDetailView>, MovieDetailDelegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner, movieid: Int)
}
