package com.attt.burger_joint.uitests.burgerlist

import android.content.Intent
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.attt.burger_joint.R
import com.attt.burger_joint.activities.MainActivity
import com.attt.burger_joint.uitests.utils.first
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class AddToCartTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapAddToCart_numberOfItemsInCartIncreased() {

        onView(first<View>(withId(R.id.btnAddToCart)))
            .perform(click())

        onView(withId(R.id.tvCartCount))
            .check(matches(withText("1")))
    }
}