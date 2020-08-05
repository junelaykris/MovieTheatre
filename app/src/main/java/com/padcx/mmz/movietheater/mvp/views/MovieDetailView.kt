package com.padcx.mmz.movietheater.mvp.views

import com.padcx.mmz.movietheater.data.vos.CastVO
import com.padcx.mmz.movietheater.data.vos.CreaterVO
import com.padcx.mmz.movietheater.data.vos.MovieDetailVO

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
interface MovieDetailView : BaseView {
    fun displayMovieDetail(moviedetail: MovieDetailVO)
    fun displayCrewList(list: List<CreaterVO>)
    fun displayCastList(list: List<CastVO>)
}