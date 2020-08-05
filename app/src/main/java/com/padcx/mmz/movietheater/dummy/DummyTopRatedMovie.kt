package com.padcx.mmz.movietheater.dummy

import com.padcx.mmz.movietheater.data.vos.PopularMovieVO
import com.padcx.mmz.movietheater.data.vos.TopRateMovieVO

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
fun getDummyTopRatedMovieList(): List<TopRateMovieVO> {
    val arr1 = ArrayList<Int>()
    arr1.add(35)
    arr1.add(10749)

    val arr2 = ArrayList<Int>()
    arr2.add(18)
    arr2.add(14)
    arr2.add(27)

    val data1 = TopRateMovieVO(
        1,
        "/wO5QSWZPBT71gMLvrRex0bVc0V9.jpg",
        "The Kissing Booth 2",
        "With college decisions looming....",
        12.4,
        "/wO5QSWZPBT71gMLvrRex0bVc0V9.jpg",
        "2020-07-24",
        "en",
        7.5,
        1005
    )

    val data2 = TopRateMovieVO(
        2,
        "/vPYgvd2MwHlxTamAOjwVQp4qs1W.jpg",
        "Constantine",
        "John Constantine has literally been to Hell and back.....",
        120.4,
        "/wO5QSWZPBT71gMLvrRex0bVc0V9.jpg",
        "2005-02-08",
        "en",
        7.5,
        1005
    )
    return arrayListOf(data1, data2)
}