package com.padcx.mmz.movietheater.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.mmz.movietheater.data.vos.*

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
@Dao
interface MovieDao {
    @Query("SELECT * FROM movies where popular=1")
    fun getAllPopularMovie(): LiveData<List<PopularMovieVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPopularMovies(movie: List<PopularMovieVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovieData(popularmovie: PopularMovieVO)

    @Query("SELECT * FROM movies WHERE id = :id")
    fun findBurgerById(id : Int) : LiveData<PopularMovieVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGenre(news: List<GenreVO>)

    @Query("SELECT * FROM genres")
    fun getAllGenre(): LiveData<List<GenreVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllDiscoverList(discover: List<DiscoverVO>)

    /*@Query("SELECT * FROM discover")
    fun getAllDiscover(): LiveData<List<PopularMovieVO>>*/

    @Query("SELECT * FROM movies where genre_ids in (:id)")
    fun getAllDiscover(id:Int): LiveData<List<PopularMovieVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTopratedList(discover: List<TopRateMovieVO>)

    @Query("SELECT * FROM topratedmovies")
    fun getAllTopRatedMovie(): LiveData<List<TopRateMovieVO>>

    @Query("SELECT * FROM actors")
    fun getAllActors(): LiveData<List<ActorVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllActors(discover: List<ActorVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetailData(moviedetail: MovieDetailVO)

    @Query("select * from movie_detail where id=:movie_id")
    fun getAllMovieDetail(movie_id: Int): LiveData<MovieDetailVO>

   /* @Query("select * from creator")
    fun getAllCrewList(): LiveData<List<CreaterVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCrewData(generic: List<CreaterVO?>)

    @Query("select * from castactor")
    fun getAllCastList(): LiveData<List<CastVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCastData(generic: List<CastVO?>)*/
}