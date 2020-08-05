package com.padcx.mmz.movietheater.dummy

import com.padcx.mmz.movietheater.data.vos.ActorVO
import com.padcx.mmz.movietheater.data.vos.GenreVO
import com.padcx.mmz.movietheater.data.vos.PopularMovieVO

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
fun getDummyPopularActor(): List<ActorVO> {
    val data1 = ActorVO(
        1,
        false,
        1,
        "Acting",
        "XIAO ZHAN",
        8005.20,
        "/iEWtgDu0OweicGOl1rxybzCaota.jpg"
    )

    val data2 = ActorVO(
        1,
        false,
        1,
        "Acting",
        "WANG YIBO",
        1005.91,
        "/fAcrRVZqLMVDVcgfvf7xmY7QRtY.jpg"
    )
    return arrayListOf(data1, data2)
}