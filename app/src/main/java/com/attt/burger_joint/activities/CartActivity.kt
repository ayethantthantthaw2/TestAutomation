package com.attt.burger_joint.activities

import CartAdapter
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.transition.Transition
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.attt.burger_joint.R
import com.attt.burger_joint.data.vos.BurgerVO
import com.attt.burger_joint.mvp.presenters.CartPresenter
import com.attt.burger_joint.mvp.presenters.impls.CartPresenterImpl
import com.attt.burger_joint.mvp.views.CartView
import com.jakewharton.rxbinding4.view.visibility
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_main.toolbar

class CartActivity : BaseActivity(), CartView {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CartActivity::class.java)
        }
    }

    private lateinit var mBurgerAdapter: CartAdapter
    private lateinit var mPresenter: CartPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTransition()
        setContentView(R.layout.activity_cart)
        setSupportActionBar(toolbar)
        setUpPresenter()
        setUpListeners()
        setUpRecycler()
        mPresenter.onUIReady(this)
    }

    private fun setUpTransition(){
        with(window){
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            val slideTransition = Slide()
            slideTransition.slideEdge = Gravity.RIGHT
            slideTransition.interpolator = AccelerateDecelerateInterpolator()
            slideTransition.duration = 500
            enterTransition = slideTransition
            exitTransition = slideTransition
        }
    }

    private fun setUpListeners() {
        btnCheckOut.setOnClickListener { mPresenter.onTapCheckout() }
        ivCancel.setOnClickListener { mPresenter.onTapCancelThankYouMessage() }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<CartPresenterImpl, CartView>()
    }

    private fun setUpRecycler() {
        mBurgerAdapter = CartAdapter(mPresenter)
        rvCart.adapter = mBurgerAdapter
        rvCart.layoutManager = GridLayoutManager(applicationContext, 1)
        //rvCart.addItemDecoration(ItemOffsetDecoration(context, R.dimen.margin_small))
        rvCart.itemAnimator = DefaultItemAnimator().apply { addDuration = 300 }
    }

    override fun displayItemsInCart(burgers: List<BurgerVO>) {
        mBurgerAdapter.setNewData(burgers)
    }

    override fun animateRemoveItemFromCart(adapterPosition: Int) {
        mBurgerAdapter.notifyItemRemoved(adapterPosition)
    }

    override fun displayThankYouMessage() {
        rlThankYouMessage.visibility = View.VISIBLE

        val animator = ObjectAnimator.ofFloat(rlThankYouMessage, View.TRANSLATION_Y
            , rlThankYouMessage.height.toFloat(), 0f)
        animator.interpolator = OvershootInterpolator()
        animator.start()

    }

    override fun hideThankYouMessage() {
        val animator = ObjectAnimator.ofFloat(rlThankYouMessage
            , View.TRANSLATION_Y
            ,0f
            , rlThankYouMessage.height.toFloat())
        animator.addListener(object: AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator) {
                rlThankYouMessage.visibility=View.GONE
            }
        })
        animator.start()

    }
}