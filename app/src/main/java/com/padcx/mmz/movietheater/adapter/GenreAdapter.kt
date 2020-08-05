package com.padcx.mmz.movietheater.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.padcx.mmz.movietheater.data.vos.GenreVO
import com.padcx.mmz.movietheater.fragment.ActionFragment

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
class GenreAdapter(
    val context: Context,
    val fm: FragmentManager,
    genreList: List<GenreVO>
) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var mContext = context
    private var genreslist: List<GenreVO> = genreList

    override fun getItem(position: Int): Fragment {
        return ActionFragment.newInstance(mContext,genreslist[position].id)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return genreslist[position].name
    }


    override fun getCount(): Int {
        return genreslist.size
    }
}