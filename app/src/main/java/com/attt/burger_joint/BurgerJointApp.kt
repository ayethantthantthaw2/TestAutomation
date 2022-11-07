package com.attt.burger_joint

import android.app.Application
import com.attt.burger_joint.data.models.impls.BurgerModelImpl
import com.attt.burger_joint.dummy.getDummyBurgers
import com.attt.burger_joint.persitence.BurgerJointDatabase


class BurgerJointApp : Application() {
    override fun onCreate() {
        super.onCreate()
        BurgerModelImpl.init(applicationContext)
        deleteAllBurgers()
        prepopulateBurgers()
    }

    private fun deleteAllBurgers(){
        BurgerJointDatabase.getInstance(applicationContext)
            .getBurgerDao()
            .deleteAllBurgers()
    }

    private fun prepopulateBurgers(){
        BurgerJointDatabase.getInstance(applicationContext)
            .getBurgerDao()
            .insertBurgers(getDummyBurgers())
    }
}