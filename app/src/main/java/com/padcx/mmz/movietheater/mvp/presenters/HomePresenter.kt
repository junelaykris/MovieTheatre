package com.padcx.mmz.movietheater.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.movietheater.delegate.PopularMovieListActionDelegate
import com.padcx.mmz.movietheater.mvp.views.HomeView
import com.padcx.mmz.shared.BasePresenter

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
interface HomePresenter :BasePresenter<HomeView>, PopularMovieListActionDelegate {
    fun onUiReady(lifecycleOwner: LifecycleOwner)

    fun onUiReadyForDiscover(lifecycleOwner: LifecycleOwner,genreName: String)

    fun onTapGenreTab(lifecycleOwner: LifecycleOwner,tabid: Int)

}