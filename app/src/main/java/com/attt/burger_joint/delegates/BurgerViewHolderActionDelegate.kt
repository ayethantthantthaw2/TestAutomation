package com.attt.burger_joint.delegates

import android.widget.ImageView
import com.attt.burger_joint.data.vos.BurgerVO

interface BurgerViewHolderActionDelegate {
    fun onTapBurger(burger : BurgerVO, burgerImageView: ImageView)
    fun onTapAddToCart(burger : BurgerVO, burgerImageView: ImageView)
}