package com.attt.burger_joint.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.attt.burger_joint.mvp.presenters.LoginPresenter
import com.attt.burger_joint.mvp.views.LoginView
import utils.EM_LOGIN_FAIL_ERROR_MESSAGE


class LoginPresenterImpl : LoginPresenter, BaseAppPresenterImpl<LoginView>() {
    override fun onUIReady(owner: LifecycleOwner) {}

    override fun onTapLogin(userName: String, password: String) {
        if(userName.isNotEmpty() || password.isNotEmpty()){
            mView.navigateToMainScreen()
        } else {
            mView.showErrorMessage(EM_LOGIN_FAIL_ERROR_MESSAGE)
        }
    }
}