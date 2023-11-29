package com.ghedamsisabri.ui_testing_for_beginner

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.Helper.getText
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isTextOnScreen
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.tap
import org.hamcrest.Matcher
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun firstTestCase() {
        mainPage.isViewDisplayed()
        NextBtn.tap()
        isTextOnScreen(EXPECTED_SECOND_PAGE_TEXT)
        backBtn.isViewDisplayed()
    }

    @Test
    fun secondTestCase() {
        mainPage.isViewDisplayed()
        NextBtn.tap()
        backBtn.tap()
        isTextOnScreen(EXPECTED_MAIN_PAGE_TEXT)
        NextBtn.isViewDisplayed()
    }


    companion object{
        val NextBtn: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val mainPage: Matcher<View> by lazy { withId(R.id.main) }
        val backBtn: Matcher<View> by lazy { withId(R.id.button_back) }

        const val EXPECTED_SECOND_PAGE_TEXT = "SecondaryActivity"
        const val EXPECTED_MAIN_PAGE_TEXT = "MainActivity"
    }

}