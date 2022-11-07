package com.attt.burger_joint.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.attt.burger_joint.R
import com.attt.burger_joint.data.vos.BurgerVO
import com.attt.burger_joint.delegates.BurgerViewHolderActionDelegate
import com.attt.burger_joint.viewholders.BurgerViewHolder


class BurgerAdapter(private val mDelegate : BurgerViewHolderActionDelegate) : BaseRecyclerAdapter<BurgerViewHolder, BurgerVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurgerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_burger,parent,false)
        return BurgerViewHolder(view, mDelegate)
    }
}