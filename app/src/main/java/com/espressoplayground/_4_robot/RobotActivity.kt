package com.espressoplayground._4_robot

import android.os.Bundle
import android.view.View
import com.espressoplayground.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_robot.*
import javax.inject.Inject

class RobotActivity : DaggerAppCompatActivity(), RobotView {

    @Inject
    lateinit var presenter: RobotPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robot)

        loginButton.setOnClickListener {
            presenter.login(loginEditText.text.toString(), passwordEditText.text.toString())
        }
        presenter.bind(this)
    }

    override fun showError(message: String) {
        errorMessageTextView.text = message
        errorMessageTextView.visibility = View.VISIBLE
    }
}
