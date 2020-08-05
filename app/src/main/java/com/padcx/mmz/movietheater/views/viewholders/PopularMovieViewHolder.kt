package com.padcx.mmz.movietheater.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.mmz.movietheater.data.vos.PopularMovieVO
import com.padcx.mmz.movietheater.delegate.PopularMovieListActionDelegate
import com.padcx.mmz.movietheater.utils.MOVIE_PATH
import kotlinx.android.synthetic.main.popular_films_serials_items.view.*

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
class PopularMovieViewHolder(
    itemView: View,
    mDelegate: PopularMovieListActionDelegate
) :
    BaseViewHolder<PopularMovieVO>(itemView) {
    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapListItem(it)
            }
        }
    }

    override fun bindData(data: PopularMovieVO) {
        mData = data

        Glide.with(itemView.context)
            .load(MOVIE_PATH + data.backdrop_path)
            .into(itemView.iv_movie)

        itemView.tv_movie_name.text = data.original_title
        itemView.tv_rating.text = data.vote_average.toString()

    }
}