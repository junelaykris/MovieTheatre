package com.padcx.mmz.movietheater.network

import com.padcx.mmz.movietheater.data.vos.MovieDetailVO
import com.padcx.mmz.movietheater.responses.*
import com.padcx.mmz.movietheater.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */

interface MovieApi {

    @GET(GET_POPULAR_MOVIE)
    fun getPopularMovieList(@Query(PARAM_API_KEY) apiKey: String): Observable<PopularMoviesResponse>

    @GET(GET_GENRE)
    fun getGENREList(@Query(PARAM_API_KEY) apiKey: String): Observable<GenreResponse>

    @GET(GET_DISCOVER)
    fun getDiscoverList(
        @Query(PARAM_API_KEY) apiKey: String,
        @Query("with_genres") withGeneric: String
    ): Observable<PopularMoviesResponse>


    @GET(GET_TOPRATED)
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String
    ): Observable<TopRateMovieResponse>


    @GET(GET_NOWPLAYING)
    fun getNowPlayingMovies(
        @Query("api_key") apiKey: String
    ): Observable<TopRateMovieResponse>



    @GET(GET_ACTOR)
    fun getActorList(
        @Query("api_key") apiKey: String
    ): Observable<GetActorResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetailById(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String,
        @Query("append_to_response") mcredits: String
    ): Observable<MovieDetailVO>


    @GET("movie/{movie_id}/credits")
    fun getMovieDetailByActorsAndCreator(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Observable<GetActorAndCreatorResponse>


    @GET("movie/{movie_id}/videos")
    fun getVideoIdByMovieId(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Observable<VideoResponse>

    /* @GET("movie/{movie_id}/credits")
     fun getMovieDetail(@Query(PARAM_API_KEY) apiKey : String,@Path("movie_id") movieID:Int) : Observable<MovieVO>*/
}