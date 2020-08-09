package com.padcx.mmz.movietheater.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.padcx.mmz.movietheater.R
import com.padcx.mmz.movietheater.activities.MovieDetailActivity
import com.padcx.mmz.movietheater.data.vos.TopRateMovieVO
import com.padcx.mmz.movietheater.delegate.videoplaydelegate
import com.padcx.mmz.movietheater.utils.MOVIE_PATH
import kotlinx.android.synthetic.main.movie_view_item.view.*

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
class MovieItemViewPagerAdapter(
    context: Context,
    data: MutableList<TopRateMovieVO>,
    private val mDelegate: videoplaydelegate
) : PagerAdapter() {

    private val mContext = context
    private var mData = data
    private val delegate = mDelegate

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(mContext).inflate(R.layout.movie_view_item, container, false)

        //   view.iv_movie_item.setImageResource(mData[position].movieImg)

        Glide.with(mContext)
            .load(("$MOVIE_PATH${mData[position].poster_path}"))
            .placeholder(R.drawable.itsokaytonotbeokay)
            .into(view.iv_movie_item)

        view.nowplaying.text=mData[position].original_title

        view.iv_movie_item.setOnClickListener {
            delegate.onTapVideo(mData[position].id)
            Log.d("Movieplay id", "" + mData[position].id)
        }

        container.addView(view)
        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return 5
    }

    fun setNewData(data: MutableList<TopRateMovieVO>){
        mData=data
    }
}