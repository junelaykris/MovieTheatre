package com.padcx.mmz.movietheater.fragment

import android.content.Context
import androidx.fragment.app.Fragment

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
class DocumentaryFragment:Fragment(){

    companion object {
        var mcontext: Context? = null
        fun newInstance(context: Context): DocumentaryFragment {
            mcontext = context
            return DocumentaryFragment()
        }
    }
}