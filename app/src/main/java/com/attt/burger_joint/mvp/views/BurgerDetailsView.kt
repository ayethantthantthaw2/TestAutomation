package com.attt.burger_joint.mvp.views

import com.attt.burger_joint.data.vos.BurgerVO


interface BurgerDetailsView : BaseView {
    fun displayBurgerDetails(burger : BurgerVO)
}