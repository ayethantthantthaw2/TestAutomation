package com.attt.burger_joint.mvp.presenters.impls

import com.attt.burger_joint.mvp.presenters.AbstractBasePresenter
import com.attt.burger_joint.mvp.presenters.BasePresenter
import com.attt.burger_joint.mvp.views.BaseView


abstract class BaseAppPresenterImpl<V : BaseView> : AbstractBasePresenter<V>(), BasePresenter<V>
