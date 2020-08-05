package com.padcx.mmz.movietheater.delegate

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.movietheater.data.vos.ActorVO
import com.padcx.mmz.movietheater.data.vos.DiscoverVO
import com.padcx.mmz.movietheater.data.vos.PopularMovieVO
import com.padcx.mmz.movietheater.data.vos.TopRateMovieVO
import com.padcx.mmz.movietheater.mvp.presenters.BasePresenter
import com.padcx.mmz.movietheater.mvp.presenters.HomePresenter
import com.padcx.mmz.movietheater.mvp.views.HomeView

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
interface PopularMovieListActionDelegate {
    fun onTapListItem(entity : PopularMovieVO)
    fun onTapActorItem(entity : ActorVO)
    fun onTapDiscoverListItem(entity : PopularMovieVO)
    fun onTapShowCaseItem(entity : TopRateMovieVO)
}