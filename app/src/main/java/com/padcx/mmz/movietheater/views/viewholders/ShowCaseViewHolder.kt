package com.padcx.mmz.movietheater.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.mmz.movietheater.data.vos.TopRateMovieVO
import com.padcx.mmz.movietheater.delegate.PopularMovieListActionDelegate
import com.padcx.mmz.movietheater.delegate.videoplaydelegate
import com.padcx.mmz.movietheater.utils.MOVIE_PATH
import com.padcx.mmz.shared.BaseViewHolder
import kotlinx.android.synthetic.main.showcase_item_layout.view.*

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
class ShowCaseViewHolder(
    itemView: View,
    mDelegate: videoplaydelegate
) :
    BaseViewHolder<TopRateMovieVO>(itemView) {
    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapVideo(it.id)
                //mDelegate.onTapShowCaseItem(it)
            }
        }
    }

    override fun bindData(data: TopRateMovieVO) {
        mData = data

        Glide.with(itemView.context)
            .load(MOVIE_PATH + data.backdrop_path)
            .into(itemView.iv_movie_item)

        itemView.top_mvname.text = data.original_title
        itemView.top_release_date.text = data.release_date


    }
}