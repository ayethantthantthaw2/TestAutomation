package com.attt.burger_joint.uitests.login

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.attt.burger_joint.R
import com.attt.burger_joint.activities.LoginActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import utils.EM_LOGIN_FAIL_ERROR_MESSAGE

@RunWith(AndroidJUnit4ClassRunner::class)
open class LoginFailTest {

    private val activityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun checkLoginButtonIsDisplayed() {
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
    }

    @Test
    fun enterInformation_navigateToMainScreen() {
        onView(withId(R.id.etUserName)).perform(
            typeText(""),
            closeSoftKeyboard()
        )
        onView(withId(R.id.etPassword)).perform(
            typeText(""),
            closeSoftKeyboard()
        )
        onView(withId(R.id.btnLogin)).perform(click())

        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(EM_LOGIN_FAIL_ERROR_MESSAGE)))
    }
}

