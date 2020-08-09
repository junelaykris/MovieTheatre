package com.padcx.mmz.movietheater.mvp.views

import com.padcx.mmz.movietheater.data.vos.CreaterVO
import com.padcx.mmz.movietheater.data.vos.MovieDetailVO
import com.padcx.mmz.movietheater.data.vos.VideoVO
import com.padcx.mmz.shared.BaseView

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
interface VideoView:BaseView {
    fun displayVideo(list: List<VideoVO>)
}