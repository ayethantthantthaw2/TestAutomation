package com.attt.burger_joint.mvp.presenters

import androidx.lifecycle.ViewModel
import com.attt.burger_joint.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>, ViewModel() {

    protected lateinit var mView : T

    override fun initPresenter(view: T){
        mView = view
    }
}