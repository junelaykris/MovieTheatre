package com.padcx.mmz.movietheater.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.movietheater.R
import com.padcx.mmz.movietheater.data.vos.TopRateMovieVO
import com.padcx.mmz.movietheater.delegate.PopularMovieListActionDelegate
import com.padcx.mmz.movietheater.delegate.videoplaydelegate
import com.padcx.mmz.movietheater.views.viewholders.ShowCaseViewHolder

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
class TopRatedMovieAdapter(private val mDelegate: videoplaydelegate) : BaseRecyclerAdapter<ShowCaseViewHolder, TopRateMovieVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.showcase_item_layout, parent, false)
        return ShowCaseViewHolder(view,mDelegate)
    }
}