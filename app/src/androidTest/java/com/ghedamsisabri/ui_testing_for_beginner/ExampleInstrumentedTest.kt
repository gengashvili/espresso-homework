package com.ghedamsisabri.ui_testing_for_beginner

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.Helper.assertIsViewDisplayed
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
        mainPage.assertIsViewDisplayed()
        nextBtn.tap()
        Assert.assertTrue(isTextOnScreen(EXPECTED_SECOND_PAGE_TEXT))
        backBtn.assertIsViewDisplayed()
    }

    @Test
    fun secondTestCase() {
        mainPage.assertIsViewDisplayed()
        nextBtn.tap()
        backBtn.tap()
        Assert.assertTrue(isTextOnScreen(EXPECTED_MAIN_PAGE_TEXT))
        nextBtn.assertIsViewDisplayed()
    }


    companion object{
        val nextBtn: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val mainPage: Matcher<View> by lazy { withId(R.id.main) }
        val backBtn: Matcher<View> by lazy { withId(R.id.button_back) }

        const val EXPECTED_SECOND_PAGE_TEXT = "SecondaryActivity"
        const val EXPECTED_MAIN_PAGE_TEXT = "MainActivity"
    }

}