package com.attt.burger_joint.mvp.views

interface LoginView : BaseView{
    fun navigateToMainScreen()
    fun showErrorMessage(message : String)
}