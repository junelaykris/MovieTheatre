package com.padcx.mmz.movietheater.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.padcx.mmz.movietheater.R
import com.padcx.mmz.movietheater.data.vos.ActorVO
import com.padcx.mmz.movietheater.utils.MOVIE_PATH
import com.padcx.mmz.shared.BaseViewHolder
import kotlinx.android.synthetic.main.actor_list_item.view.*

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
class ActorViewHolder(itemView: View) :
    BaseViewHolder<ActorVO>(itemView) {
    init {
    }

    override fun bindData(data: ActorVO) {
        mData = data

        itemView.actorname.text = data.name
        itemView.likecount.text = "You Like ${data.popularity} Movies"

        Glide.with(itemView.profile_image)
            .load(("$MOVIE_PATH${data.profile_path}"))
            .apply(RequestOptions.placeholderOf(R.drawable.itsokaytonotbeokay))
            .into(itemView.profile_image)

        /*  Glide.with(itemView.context)
              .load(data.backdrop_path)
              .into(itemView.iv_movie)*/

       /* Glide.with(itemView.context)
            .load(MOVIE_PATH + data.backdrop_path)
            .into(itemView.iv_movie)

        itemView.tv_movie_name.text = data.title
        itemView.tv_rating.text = data.vote_average.toString()*/

    }
}