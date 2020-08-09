package com.padcx.mmz.shared

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Myint Myint Zaw on 8/1/2020.
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mData: T? = null

    abstract fun bindData(data: T)
}