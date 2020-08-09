package com.padcx.mmz.movietheater.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.padcx.mmz.movietheater.R
import com.padcx.mmz.movietheater.adapter.CastAdapter
import com.padcx.mmz.movietheater.adapter.CreatorAdapter
import com.padcx.mmz.movietheater.data.vos.CastVO
import com.padcx.mmz.movietheater.data.vos.CreaterVO
import com.padcx.mmz.movietheater.data.vos.MovieDetailVO
import com.padcx.mmz.movietheater.mvp.presenters.DetailPresenter
import com.padcx.mmz.movietheater.mvp.presenters.DetailPresenterImpl
import com.padcx.mmz.movietheater.mvp.views.MovieDetailView
import com.padcx.mmz.movietheater.utils.MOVIE_PATH
import com.padcx.mmz.shared.BaseActivity
import kotlinx.android.synthetic.main.about_film.*
import kotlinx.android.synthetic.main.detail_action_bar.*
import kotlinx.android.synthetic.main.movie_detail_activity.*

/**
 * Created by Myint Myint Zaw on 8/2/2020.
 */
class MovieDetailActivity : BaseActivity(), MovieDetailView {
    private lateinit var mPresenter: DetailPresenter

    private lateinit var castAdapter: CastAdapter
    private lateinit var crewAdapter: CreatorAdapter

    companion object {

        const val movieid = "Movie Id Extra"

        fun newItent(context: MainActivity, mId: Int): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(movieid, mId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail_activity)
        val movie_id = intent.getIntExtra(movieid, 0)
        setUpPresenter()

        Log.d("Movie id", "" + movieid)

        imageView5.setOnClickListener {
            onBackPressed()
        }

        setUpRecyclerView()
        mPresenter.onUiReady(this, movie_id)

    }

    private fun setUpRecyclerView() {
        castAdapter = CastAdapter()
        val mlinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        cast_recyclerview.layoutManager = mlinearLayoutManager
        cast_recyclerview.adapter = castAdapter

        crewAdapter = CreatorAdapter()
        val llinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        crew_recyclerview.layoutManager = llinearLayoutManager
        crew_recyclerview.adapter = crewAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayMovieDetail(moviedetail: MovieDetailVO) {
        original_flim.text = moviedetail.original_title
        description.text = moviedetail.overview
        production.text = moviedetail.tagline

        Glide.with(movie_poster_image)
            .load(("$MOVIE_PATH${moviedetail.poster_path}"))
            .apply(RequestOptions.placeholderOf(R.drawable.itsokaytonotbeokay))
            .into(movie_poster_image)
        movietitle.text = moviedetail.original_title
        overview.text = moviedetail.overview

        crewAdapter.setNewData(moviedetail.credits.crew!!.toMutableList())

        castAdapter.setNewData(moviedetail.credits.cast!!.toMutableList())
    }

    override fun displayCrewList(list: List<CreaterVO>) {
        // crewAdapter.setNewData(list.toMutableList())
    }

    override fun displayCastList(list: List<CastVO>) {
        //  castAdapter.setNewData(list.toMutableList())
    }
}