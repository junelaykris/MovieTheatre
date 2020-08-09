package com.padcx.mmz.movietheater.activities

import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.mmz.movietheater.BuildConfig
import com.padcx.mmz.movietheater.R
import com.padcx.mmz.movietheater.adapter.*
import com.padcx.mmz.movietheater.data.vos.*
import com.padcx.mmz.movietheater.delegate.videoplaydelegate
import com.padcx.mmz.movietheater.mvp.presenters.HomePresenter
import com.padcx.mmz.movietheater.mvp.presenters.HomePresenterImpl
import com.padcx.mmz.movietheater.mvp.views.HomeView
import com.padcx.mmz.shared.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : BaseActivity(), HomeView, videoplaydelegate {

    private lateinit var mPopularMovieAdapter: PopularMovieAdapter
    private lateinit var movieViewPagerAdapter: MovieItemViewPagerAdapter

    private lateinit var mTopratedAdapter: TopRatedMovieAdapter

    private lateinit var mActorAdapter: ActorAdapter

    private lateinit var homePresenter: HomePresenter
    private var vpImageList: MutableList<MovieImage> = ArrayList()
    private var currentPage = 0
    private var timer: Timer? = null
    private val firstDelayMinute: Long = 500//delay in milliseconds before task is to be executed
    private val delayIntervalMinute: Long =
        5000 // time in milliseconds between successive task executions.

    lateinit var vpGenreAdapter: GenreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()
        setUpRecyclerView()
        homePresenter.onUiReady(this)
    }

    private fun movieItemShowTimer() {
        val numberOfPage = 4
        /*After setting the adapter use the timer */
        val handler = Handler()
        val update = Runnable {
            if (currentPage == numberOfPage - 1) {
                currentPage = 0
            }
            this.vp_movie_item.setCurrentItem(currentPage++, true)
        }

        timer = Timer() // This will create a new Thread
        timer!!.schedule(object : TimerTask() { // task to be scheduled
            override fun run() {
                handler.post(update)
            }
        }, firstDelayMinute, delayIntervalMinute)

    }

    override fun displayPopularItems(movieList: List<PopularMovieVO>) {
        mPopularMovieAdapter.setNewData(movieList.toMutableList())
    }

    override fun displayGenreItems(genreList: List<GenreVO>) {
        vpGenreAdapter = GenreAdapter(
            this,
            supportFragmentManager, genreList
        )
        vp_genres.adapter = vpGenreAdapter
        tab_genre.setupWithViewPager(vp_genres)

        /*  tab_genre.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
              override fun onTabReselected(tab: TabLayout.Tab?) {
              }

              override fun onTabUnselected(tab: TabLayout.Tab?) {

              }

              override fun onTabSelected(tab: TabLayout.Tab?) {
                  homePresenter.onTapGenreTab(this@MainActivity,tab!!.position)
                  Toast.makeText(this@MainActivity,""+tab.position,Toast.LENGTH_SHORT).show()
                 // homePresenter.onUiReadyForDiscover(this@MainActivity,tab.toString())
                     //homePresenter.onTapGenreTab(this@MainActivity,genreList.get(tab.position).id)
              }

          })
  */
    }

    override fun displayDiscoverItems(discoverList: List<PopularMovieVO>) {

    }

    override fun displayShowCaseItems(showcaseList: List<TopRateMovieVO>) {
        mTopratedAdapter.setNewData(showcaseList.toMutableList())
    }

    override fun displayActorList(actorList: List<ActorVO>) {
        mActorAdapter.setNewData(actorList.toMutableList())
    }

    override fun navigateToDetail(id: Int) {
        startActivity(MovieDetailActivity.newItent(this, id))
    }

    override fun displayNowplayingItems(showcaseList: List<TopRateMovieVO>) {
        movieViewPagerAdapter = MovieItemViewPagerAdapter(this, showcaseList.toMutableList(), this)
        vp_movie_item.adapter = movieViewPagerAdapter
        tl_movie_item.setupWithViewPager(vp_movie_item)
       // showBanner(showcaseList.toMutableList())
      //  movieItemShowTimer()
    }

    private fun setUpRecyclerView() {
        mPopularMovieAdapter = PopularMovieAdapter(homePresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_popular_movie.layoutManager = linearLayoutManager
        rv_popular_movie.adapter = mPopularMovieAdapter


        mTopratedAdapter = TopRatedMovieAdapter(this)
        val mlinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_showcase_movie.layoutManager = mlinearLayoutManager
        rv_showcase_movie.adapter = mTopratedAdapter

        mActorAdapter = ActorAdapter()
        val llLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_actors.layoutManager = llLayoutManager
        rv_actors.adapter = mActorAdapter

    }

    private fun setUpPresenter() {
        homePresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        homePresenter.initPresenter(this)
    }

    override fun onTapVideo(movieId: Int) {
        startActivity(VideoPlayerDetailActivity.newIntents(this, movieId))
        //Toast.makeText(this, "Video PLaying..."+movieId, Toast.LENGTH_SHORT).show()
    }
}