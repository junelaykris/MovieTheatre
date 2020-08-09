package com.padcx.mmz.shared



interface BasePresenter<T: BaseView> {
    fun initPresenter(view:T)
}