package com.padcx.mmz.movietheater.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.mmz.movietheater.R
import com.padcx.mmz.movietheater.activities.MainActivity
import com.padcx.mmz.movietheater.activities.MovieDetailActivity.Companion.newItent
import com.padcx.mmz.movietheater.adapter.ActionMovieAdapter
import com.padcx.mmz.movietheater.data.vos.*
import com.padcx.mmz.movietheater.mvp.presenters.HomePresenter
import com.padcx.mmz.movietheater.mvp.presenters.HomePresenterImpl
import com.padcx.mmz.movietheater.mvp.views.HomeView
import kotlinx.android.synthetic.main.fragment_genre.view.*

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
class ActionFragment : Fragment(), HomeView {
    private lateinit var mActionAdapter: ActionMovieAdapter
    private lateinit var homePresenter: HomePresenter

    companion object {
        var mcontext: Context? = null
        private var genrename: Long = 0
        fun newInstance(context: Context, genreId: Long): ActionFragment {
            genrename = genreId
            mcontext = context
            return ActionFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_genre, container, false)
        setUpPresenter()
        setUpRecyclerView(view)
        // homePresenter.onUiReadyForDiscover(this, genrename.toString())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.onUiReadyForDiscover(this, genrename.toString())
    }

    private fun setUpRecyclerView(view: View) {
        mActionAdapter = ActionMovieAdapter(homePresenter)
        val linearLayoutManager =
            LinearLayoutManager(mcontext, LinearLayoutManager.HORIZONTAL, false)
        view.rv_genre.layoutManager = linearLayoutManager
        view.rv_genre.adapter = mActionAdapter
    }

    private fun setUpPresenter() {
        homePresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        homePresenter.initPresenter(this)
    }

    override fun displayPopularItems(movieList: List<PopularMovieVO>) {

    }

    override fun displayGenreItems(genreList: List<GenreVO>) {

    }

    override fun displayDiscoverItems(discoverList: List<PopularMovieVO>) {
        mActionAdapter.setNewData(discoverList.toMutableList())
    }

    override fun displayShowCaseItems(showcaseList: List<TopRateMovieVO>) {

    }

    override fun displayActorList(showcaseList: List<ActorVO>) {
    }

    override fun navigateToDetail(id: Int) {
        startActivity(newItent(mcontext as MainActivity, id))
    }

    override fun displayNowplayingItems(showcaseList: List<TopRateMovieVO>) {

    }

    override fun onStart() {
        super.onStart()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

}