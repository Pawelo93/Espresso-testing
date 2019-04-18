package com.espressoplayground._2_apiRequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.espressoplayground.R
import com.espressoplayground.network.Post
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_api_request.*
import javax.inject.Inject

class ApiRequestActivity : AppCompatActivity(), ApiRequestView {

    @Inject
    lateinit var presenter: ApiRequestPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_request)

        presenter.bind(this)
        presenter.makeApiCall()
    }

    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }

    override fun showPost(post: Post) {
        titleTextView.text = post.title
        bodyTextView.text = post.body
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun showErrorMessage(message: String) {
        errorTextView.text = message
    }
}