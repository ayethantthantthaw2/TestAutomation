package com.attt.burger_joint.mvp.views

import android.widget.ImageView
import com.attt.burger_joint.data.vos.BurgerVO

interface MainView : BaseView{
    fun displayBurgerList(burgerList : List<BurgerVO>)
    fun navigateToBurgerDetailsScreen(burgerId : Int, burgerImageView : ImageView)
    fun navigateToCartScreen()
    fun addBurgerToCart(burger : BurgerVO, burgerImageView : ImageView)
    fun displayCountInCart(burgersInCartCount : Int)

}