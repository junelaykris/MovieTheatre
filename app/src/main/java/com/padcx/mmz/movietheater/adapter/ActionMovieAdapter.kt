package com.padcx.mmz.movietheater.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.movietheater.R
import com.padcx.mmz.movietheater.data.vos.DiscoverVO
import com.padcx.mmz.movietheater.data.vos.PopularMovieVO
import com.padcx.mmz.movietheater.delegate.PopularMovieListActionDelegate
import com.padcx.mmz.movietheater.views.viewholders.MovieViewHolder

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
class ActionMovieAdapter(private val mDelegate: PopularMovieListActionDelegate) :
    BaseRecyclerAdapter<MovieViewHolder, PopularMovieVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_films_serials_items, parent, false)
        return MovieViewHolder(view,mDelegate)
    }
}