package com.attt.burger_joint.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.attt.burger_joint.mvp.presenters.AbstractBasePresenter
import com.attt.burger_joint.mvp.views.BaseView


abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    inline fun <reified T : AbstractBasePresenter<W>, reified W:BaseView> getPresenter(): T {
        val presenter = ViewModelProvider(this)[T::class.java]
        if (this is W) presenter.initPresenter(this)
        return presenter
    }
}