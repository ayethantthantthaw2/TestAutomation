package com.attt.burger_joint.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.attt.burger_joint.mvp.views.BaseView

interface BasePresenter<V: BaseView> {
    fun onUIReady(owner: LifecycleOwner)
    fun initPresenter(view: V)
}