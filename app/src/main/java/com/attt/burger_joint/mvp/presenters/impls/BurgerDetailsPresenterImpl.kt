package com.attt.burger_joint.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.attt.burger_joint.data.models.impls.BurgerModelImpl
import com.attt.burger_joint.mvp.presenters.BurgerDetailsPresenter
import com.attt.burger_joint.mvp.views.BurgerDetailsView


class BurgerDetailsPresenterImpl : BurgerDetailsPresenter,
    BaseAppPresenterImpl<BurgerDetailsView>() {

    private val mBurgerModel = BurgerModelImpl

    override fun onBurgerDetailsUiReady(lifecycleOwner: LifecycleOwner, burgerDetailsId: Int) {
        mBurgerModel.findBurgerById(burgerDetailsId)
            .observe(lifecycleOwner, Observer {
                mView.displayBurgerDetails(it)
            })
    }

    override fun onUIReady(owner: LifecycleOwner) {

    }
}