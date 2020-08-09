package com.padcx.mmz.movietheater.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.movietheater.mvp.views.VideoView
import com.padcx.mmz.shared.BasePresenter

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
interface VideoPresenter : BasePresenter<VideoView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner, movieId: Int)
}