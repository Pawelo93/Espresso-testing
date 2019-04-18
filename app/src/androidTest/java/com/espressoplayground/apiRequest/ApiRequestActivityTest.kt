package com.espressoplayground.apiRequest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.espressoplayground.R
import com.espressoplayground.base.TestApp
import com.espressoplayground.base.TestTransformer
import com.espressoplayground.network.Post
import dagger.android.AndroidInjector
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when` as whenever
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class ApiRequestActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(ApiRequestActivity::class.java, true, false)

    val getOnePostUseCase: GetOnePostUseCase = mockk()
    val presenter = ApiRequestPresenter(getOnePostUseCase, TestTransformer())

    @Before
    fun setUp() {
        val app = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TestApp
        app.injector = AndroidInjector {
            (it as? ApiRequestActivity)?.presenter = presenter
        }
    }

    @Test
    fun getPostSuccess() {
        val fakePost = Post(1, 2, "Post title", "Post body")
        every { getOnePostUseCase() }.answers { (Single.just(fakePost)) }

        activityRule.launchActivity(null)

        onView(withId(R.id.titleTextView))
            .check(matches(withText("Post title")))
        onView(withId(R.id.bodyTextView))
            .check(matches(withText("Post body")))
    }

    @Test
    fun getPostFailure() {
        val throwable = Throwable("error message")
        every { getOnePostUseCase() }.answers { Single.error(throwable) }

        activityRule.launchActivity(null)

        onView(withId(R.id.progressBar))
            .check(matches(not(isDisplayed())))
        onView(withId(R.id.errorTextView))
            .check(matches(withText(throwable.message)))
    }
}