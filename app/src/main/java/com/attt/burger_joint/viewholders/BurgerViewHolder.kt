package com.attt.burger_joint.viewholders

import android.view.View
import com.attt.burger_joint.data.vos.BurgerVO
import com.attt.burger_joint.delegates.BurgerViewHolderActionDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_item_burger.view.*

class BurgerViewHolder(itemView: View, private val mDelegate: BurgerViewHolderActionDelegate)
    : BaseViewHolder<BurgerVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapBurger(it, itemView.ivBurger)
            }
        }

        itemView.btnAddToCart.setOnClickListener {
            mData?.let {
                mDelegate.onTapAddToCart(it, itemView.ivBurger)
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