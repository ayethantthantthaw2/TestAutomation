package com.attt.burger_joint.mvp.presenters

import com.attt.burger_joint.delegates.CartViewHolderActionDelegate
import com.attt.burger_joint.mvp.views.CartView


interface CartPresenter : BasePresenter<CartView>, CartViewHolderActionDelegate {
    fun onTapCheckout()
    fun onTapCancelThankYouMessage()
}