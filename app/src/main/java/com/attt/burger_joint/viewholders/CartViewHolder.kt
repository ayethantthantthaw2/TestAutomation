package com.attt.burger_joint.viewholders

import android.view.View
import com.attt.burger_joint.data.vos.BurgerVO
import com.attt.burger_joint.delegates.CartViewHolderActionDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_item_burger.view.tvBurgerName
import kotlinx.android.synthetic.main.view_item_burger.view.tvDescription
import kotlinx.android.synthetic.main.view_item_cart.view.*

class CartViewHolder(itemView: View, private val mDelegate: CartViewHolderActionDelegate)
    : BaseViewHolder<BurgerVO>(itemView) {

    init {

        itemView.btnRemoveFromCart.setOnClickListener {
            mData?.let {
                mDelegate.onTapRemoveFromCart(it, this.adapterPosition)
            }
        }
    }

    override fun bindData(data: BurgerVO) {
        mData = data

        itemView.tvBurgerName.text = data.burgerName
        itemView.tvDescription.text = data.burgerDescription

        Glide.with(itemView.ivBurger)
            .load(data.burgerImageUrl)
            .into(itemView.ivBurger)
    }
}