package com.attt.burger_joint.impls

import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.attt.burger_joint.data.models.BurgerModel
import com.attt.burger_joint.data.models.impls.BurgerModelImpl
import com.attt.burger_joint.data.models.impls.MockBurgerModelImpl
import com.attt.burger_joint.data.vos.BurgerVO
import com.attt.burger_joint.dummy.getDummyBurgers
import com.attt.burger_joint.mvp.presenters.impls.MainPresenterImpl
import com.attt.burger_joint.mvp.views.MainView

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {

    private lateinit var mPresenter: MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView

    private lateinit var mBurgerModel: BurgerModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        BurgerModelImpl.init(ApplicationProvider.getApplicationContext())
        mBurgerModel = MockBurgerModelImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mBurgerModel = this.mBurgerModel
    }


    @Test
    fun onTapAddToCart_callAddBurgerToCart() {
        val tappedBurger = BurgerVO()
        tappedBurger.burgerId = 1
        tappedBurger.burgerName = "Big Mac"
        tappedBurger.burgerImageUrl = ""
        tappedBurger.burgerDescription = "Big Mac Burger"

        val imageView = ImageView(ApplicationProvider.getApplicationContext())

        mPresenter.onTapAddToCart(tappedBurger, imageView)

        verify {
            mView.addBurgerToCart(tappedBurger, imageView)
        }
    }

    @Test
    fun onTapCart_callNavigateToCartScreen() {
        mPresenter.onTapCart()
        verify {
            mView.navigateToCartScreen()
        }
    }

    @Test
    fun onTapBurger_callNavigateToBurgerDetails() {
        val tappedBurger = BurgerVO()
        tappedBurger.burgerId = 1
        tappedBurger.burgerName = "Big Mac"
        tappedBurger.burgerImageUrl = ""
        tappedBurger.burgerDescription = "Big Mac Burger"
        val imageView = ImageView(ApplicationProvider.getApplicationContext())

        mPresenter.onTapBurger(tappedBurger, imageView)
        verify {
            mView.navigateToBurgerDetailsScreen(tappedBurger.burgerId, imageView)
        }
    }

    @Test
    fun onUIReady_callDisplayBurgerList_callDisplayCountInCart() {
        val lifeCycleOwner = mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)
        

        mPresenter.onUIReady(lifeCycleOwner)

        verify {
            mView.displayBurgerList(getDummyBurgers())
        }
    }
}