package com.padcx.mmz.movietheater.mvp.views

import com.padcx.mmz.movietheater.data.vos.*

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
interface HomeView : BaseView{

    fun displayNowplayingItems(showcaseList: List<TopRateMovieVO>)

    fun displayPopularItems(movieList:List<PopularMovieVO>)

    fun displayGenreItems(genreList:List<GenreVO>)

    fun displayDiscoverItems(discoverList: List<PopularMovieVO>)

    fun displayShowCaseItems(showcaseList: List<TopRateMovieVO>)

    fun displayActorList(showcaseList: List<ActorVO>)

    fun navigateToDetail(id: Int)

}
