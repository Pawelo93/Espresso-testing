package com.espressoplayground._4_robot

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.espressoplayground.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_robot.*
import javax.inject.Inject

class RobotActivity : AppCompatActivity(), RobotView {

    @Inject
    lateinit var presenter: RobotPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robot)

        loginButton.setOnClickListener {
            presenter.login(loginEditText.text.toString(), passwordEditText.text.toString())
        }
        presenter.bind(this)
    }

    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }

    override fun showError(message: String) {
        errorMessageTextView.text = message
        errorMessageTextView.visibility = View.VISIBLE
    }

    override fun openNextRobotActivity() {
        startActivity(Intent(this, NextRobotActivity::class.java))
    }
}
