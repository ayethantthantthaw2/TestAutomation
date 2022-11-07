package com.attt.burger_joint.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.attt.burger_joint.mvp.views.BurgerDetailsView


interface BurgerDetailsPresenter : BasePresenter<BurgerDetailsView> {
    fun onBurgerDetailsUiReady(lifecycleOwner: LifecycleOwner, burgerDetailsId: Int)
}