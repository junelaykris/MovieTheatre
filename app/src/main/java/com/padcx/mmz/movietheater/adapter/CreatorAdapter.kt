package com.padcx.mmz.movietheater.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.movietheater.R
import com.padcx.mmz.movietheater.data.vos.ActorVO
import com.padcx.mmz.movietheater.data.vos.CreaterVO
import com.padcx.mmz.movietheater.views.viewholders.CrewViewHolder
import com.padcx.mmz.shared.BaseRecyclerAdapter

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
class CreatorAdapter :
    BaseRecyclerAdapter<CrewViewHolder, CreaterVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.actor_list_item, parent, false)
        return CrewViewHolder(view)
    }
}