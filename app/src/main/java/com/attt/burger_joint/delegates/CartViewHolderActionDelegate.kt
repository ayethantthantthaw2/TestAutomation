package com.attt.burger_joint.delegates

import com.attt.burger_joint.data.vos.BurgerVO


interface CartViewHolderActionDelegate {
    fun onTapRemoveFromCart(burger : BurgerVO, adapterPosition : Int)
}