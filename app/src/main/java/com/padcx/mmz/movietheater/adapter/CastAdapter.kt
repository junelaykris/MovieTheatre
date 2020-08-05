package com.padcx.mmz.movietheater.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.movietheater.R
import com.padcx.mmz.movietheater.data.vos.ActorVO
import com.padcx.mmz.movietheater.data.vos.CastVO
import com.padcx.mmz.movietheater.delegate.MovieDetailDelegate
import com.padcx.mmz.movietheater.views.viewholders.ActorViewHolder
import com.padcx.mmz.movietheater.views.viewholders.CastViewHolder

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
class CastAdapter: BaseRecyclerAdapter<CastViewHolder, CastVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.actor_list_item, parent, false)
        return CastViewHolder(view)
    }
}