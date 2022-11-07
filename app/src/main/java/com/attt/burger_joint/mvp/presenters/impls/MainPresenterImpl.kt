package com.attt.burger_joint.mvp.presenters.impls

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.attt.burger_joint.data.models.BurgerModel
import com.attt.burger_joint.data.models.impls.BurgerModelImpl
import com.attt.burger_joint.data.vos.BurgerVO
import com.attt.burger_joint.mvp.presenters.MainPresenter
import com.attt.burger_joint.mvp.views.MainView

class MainPresenterImpl : MainPresenter, BaseAppPresenterImpl<MainView>() {

    var mBurgerModel : BurgerModel = BurgerModelImpl

    override fun onTapAddToCart(burger: BurgerVO, burgerImageView : ImageView) {
        mBurgerModel.addItemToCart(burger)
        mView.addBurgerToCart(burger, burgerImageView)
    }

    override fun onTapCart() {
        mView.navigateToCartScreen()
    }

    override fun onUIReady(owner: LifecycleOwner) {
        mBurgerModel.getAllBurgers()
            .observe(owner, Observer {
                mView.displayBurgerList(it)
            })

        mBurgerModel.getBurgersInCart()
            .observe(owner, Observer {
                mView.displayCountInCart(it.count())
            })
    }

    override fun onTapBurger(burger: BurgerVO, burgerImageView: ImageView) {
        mView.navigateToBurgerDetailsScreen(burgerId = burger.burgerId, burgerImageView = burgerImageView)
    }
}