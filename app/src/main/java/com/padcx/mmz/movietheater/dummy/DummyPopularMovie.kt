package com.padcx.mmz.movietheater.dummy

import com.padcx.mmz.movietheater.data.vos.PopularMovieVO

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
fun getDummyPopularMovieList(): List<PopularMovieVO> {
    val arr1 = ArrayList<Int>()
    arr1.add(35)
    arr1.add(10749)

    val arr2 = ArrayList<Int>()
    arr2.add(18)
    arr2.add(14)
    arr2.add(27)

    val data1 = PopularMovieVO(
        1,
        120.0,
        "/mb7wQv0adK3kjOUr9n93mANHhPJ.jpg",
        false,
        "With college decisions looming, Elle juggles her long-distance romance with Noah, changing relationship with bestie Lee and feelings for a new classmate.",
        "2020-07-24",
        arr1,
        "The Kissing Booth 2",
        "en",
        "The Kissing Booth 2",
        "/wO5QSWZPBT71gMLvrRex0bVc0V9.jpg"
    )

    val data2 = PopularMovieVO(
        2,
        120.0,
        "/vPYgvd2MwHlxTamAOjwVQp4qs1W.jpg",
        false,
        "John Constantine has literally been to Hell and back. When he teams up with a policewoman to solve the mysterious suicide of her twin sister, their investigation takes them through the world of demons and angels that exists beneath the landscape of contemporary Los Angeles.",
        "2005-02-08",
        arr2,
        "Constantine",
        "en",
        "\"Constantine\",",
        "/tIG8FwHRiHLOlWJdizp2oxdkSL2.jpg"
    )
    return arrayListOf(data1, data2)
}