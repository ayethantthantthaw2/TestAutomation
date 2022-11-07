package com.attt.burger_joint.mvp.presenters

import com.attt.burger_joint.delegates.BurgerViewHolderActionDelegate
import com.attt.burger_joint.mvp.views.MainView


interface MainPresenter :  BasePresenter<MainView>, BurgerViewHolderActionDelegate {
    fun onTapCart()
}