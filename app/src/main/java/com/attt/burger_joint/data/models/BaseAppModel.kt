package com.attt.burger_joint.data.models

import android.content.Context
import com.attt.burger_joint.persitence.BurgerJointDatabase


abstract class BaseAppModel : BaseModel() {

    protected lateinit var mDatabase: BurgerJointDatabase

    override fun init(context: Context) {
        initDatabase(context)
    }

    private fun initDatabase(context: Context) {
        mDatabase = BurgerJointDatabase.getInstance(context)
    }
}