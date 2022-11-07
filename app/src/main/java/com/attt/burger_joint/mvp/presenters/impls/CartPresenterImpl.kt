package com.attt.burger_joint.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.attt.burger_joint.data.models.impls.BurgerModelImpl
import com.attt.burger_joint.data.vos.BurgerVO
import com.attt.burger_joint.mvp.presenters.CartPresenter
import com.attt.burger_joint.mvp.views.CartView


class CartPresenterImpl : CartPresenter, BaseAppPresenterImpl<CartView>() {


    private val mBurgerModel = BurgerModelImpl

    override fun onUIReady(owner: LifecycleOwner) {
        mBurgerModel
            .getBurgersInCart()
            .observe(owner, Observer {
                mView.displayItemsInCart(it)
            })
    }

    override fun onTapRemoveFromCart(burger: BurgerVO, adapterPosition : Int) {
        mBurgerModel
            .removeItemFromCart(burger)
    }

    override fun onTapCheckout() {
        mView.displayThankYouMessage()
    }

    override fun onTapCancelThankYouMessage() {
        mView.hideThankYouMessage()
    }
}