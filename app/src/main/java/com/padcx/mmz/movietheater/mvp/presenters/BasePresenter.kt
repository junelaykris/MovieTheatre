package com.padcx.mmz.movietheater.mvp.presenters

import com.padcx.mmz.movietheater.mvp.views.BaseView

interface BasePresenter<T: BaseView> {
    fun initPresenter(view:T)
}