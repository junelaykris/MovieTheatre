package com.padcx.mmz.movietheater.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.mmz.movietheater.data.models.MoviesModel
import com.padcx.mmz.movietheater.data.models.impls.MoviesModelImpls
import com.padcx.mmz.movietheater.data.vos.*
import com.padcx.mmz.movietheater.mvp.views.HomeView

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {
    var mMoviesModel: MoviesModel = MoviesModelImpls

    private var mGenreList: MutableList<GenreVO> = arrayListOf()

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        loadAllMoviesFromAPI()

        mMoviesModel.getAllNowPlayingList(onError = {
        }).observe(lifecycleOwner, Observer {
            mView?.displayNowplayingItems(it)
        })

        mMoviesModel.getAllPopularMovies(onError = {
        }).observe(lifecycleOwner, Observer {
            mView?.displayPopularItems(it)
        })

        mMoviesModel.getAllGenres(onError = {
        }).observe(lifecycleOwner, Observer {
            mGenreList = it.toMutableList()
            mView?.displayGenreItems(it)
        })

        mMoviesModel.getAllTopRatedList(onError = {
        }).observe(lifecycleOwner, Observer {
            mView?.displayShowCaseItems(it)

        })

        mMoviesModel.getAllActorList(onError = {
        }).observe(lifecycleOwner, Observer {
            mView?.displayActorList(it)
        })
    }

    override fun onUiReadyForDiscover(lifecycleOwner: LifecycleOwner, genreName: String) {
        loadAllDiscoverListFromAPI(genreName)
    }

    override fun onTapGenreTab(lifecycleOwner: LifecycleOwner, tab: Int) {
//        val genreId = mGenreList[tab].id.toInt()
//        mNewsModel.getAllDiscoverList() {
//            // Display Error
//        }.observe(lifecycleOwner, Observer {
//            val moviesByGenre =  it.filter{
//                it.genre_ids.contains(genreId)
//            }.toList()
//
//
//
//         /*  mView?.displayDiscoverItems(moviesByGenre)*/
//        })
    }

    /* fun onTapGenreTab(genreId : Int, lifecycleOwner: LifecycleOwner){
         mNewsModel.getAllDiscoverList {
             // Display Error
         }.observe(lifecycleOwner, Observer {
            val moviesByGenre =  it.filter{
                 it.genre_ids.contains(genreId)
             }
                 .toList()

         })
     }
 */

    override fun onTapListItem(entity: PopularMovieVO) {
        mView?.navigateToDetail(entity.id)
    }

    override fun onTapActorItem(entity: ActorVO) {

    }

    override fun onTapDiscoverListItem(entity: PopularMovieVO) {
        mView?.navigateToDetail(entity.id)
    }

    override fun onTapShowCaseItem(entity: TopRateMovieVO) {
        mView?.navigateToDetail(entity.id)
    }

    private fun loadAllDiscoverListFromAPI(genreName: String) {
        mMoviesModel.getAllDiscoverListFromApiandSaveToDatabase(
            genericname = genreName,
            onSuccess = {
                mView?.displayDiscoverItems(it)
            },
            onError = {}
        )
    }

    private fun loadAllMoviesFromAPI() {
        mMoviesModel.getAllMoviesFromApiAndSaveToDatabase(
            onSuccess = {},
            onError = {}
        )

    }

}