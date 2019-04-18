package com.espressoplayground.wiremockApiRequest

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import com.espressoplayground.R
import com.espressoplayground.base.TestApp
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit.WireMockRule
import dagger.android.AndroidInjector
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ApiRequestActivityTest {

//    @get:Rule

//    @get:Rule
//    var activityRule = ActivityTestRule(ApiRequestActivity::class.java, true, false)

    @get:Rule
    var wireMockRule = WireMockRule(8080)

//    @get:Rule
//    var wireMockRule = WireMockRule()


//    @get:Rule
//    var wireMockRule = WireMockRule(8080)

    @Before
    fun setUp() {
//        wireMock = WireMock(8080)
        val app = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TestApp
        app.injector = AndroidInjector {
            //            (it as? ApiRequestActivity)?.presenter = presenter
        }
    }

    @Test
    fun test() {
//        stubBitCoinRateResponse()

//        activityRule.launchActivity(null)

        Espresso.onView(ViewMatchers.withId(R.id.titleTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Post title")))
        Espresso.onView(ViewMatchers.withId(R.id.bodyTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Post body")))
    }

    fun stubBitCoinRateResponse() {
        val url = "/posts"
        val jsonBody = "[\n" +
                "{\n" +
                "\"userId\": 1,\n" +
                "\"id\": 1,\n" +
                "\"title\": „test user”,\n" +
                "\"body\": „test body”\n" +
                "}\n" +
                "]"

//        val jsonBody = AssetReaderUtil.asset("bitcoin_rate_response.json")
        stubFor(
            get(urlPathMatching(url))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withBody(jsonBody)
                )
        )


    }

}