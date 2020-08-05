package com.padcx.mmz.movietheater.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcx.mmz.movietheater.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView>:BasePresenter<T>,ViewModel() {
    var mView : T? = null
    override fun initPresenter(view: T) {
        mView = view
    }
}