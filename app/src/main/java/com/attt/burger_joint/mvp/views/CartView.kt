package com.attt.burger_joint.mvp.views

import com.attt.burger_joint.data.vos.BurgerVO


interface CartView : BaseView {
    fun displayItemsInCart(burgers : List<BurgerVO>)
    fun displayThankYouMessage()
    fun hideThankYouMessage()
    fun animateRemoveItemFromCart(adapterPosition : Int)
}