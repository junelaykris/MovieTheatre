package com.padcx.mmz.movietheater.uitests

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcx.mmz.movietheater.R
import com.padcx.mmz.movietheater.activities.MainActivity
import com.padcx.mmz.movietheater.views.viewholders.PopularMovieViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Myint Myint Zaw on 8/5/2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class GoToMovieDetailTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnPopular_navigateToMovieDetails() {
        Espresso.onView(withId(R.id.rv_popular_movie))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<PopularMovieViewHolder>(
                    0,
                    ViewActions.click()
                )
            )

        Espresso.onView(withId(R.id.movietitle))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}