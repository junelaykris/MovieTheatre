package com.padcx.mmz.movietheater.dummy

import com.padcx.mmz.movietheater.data.vos.GenreVO
import com.padcx.mmz.movietheater.data.vos.PopularMovieVO

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
fun getDummyGenre(): List<GenreVO> {
    val data1 = GenreVO(
        1,
        "Drama"
    )

    val data2 = GenreVO(
        2,
        "Family"
    )
    return arrayListOf(data1, data2)
}