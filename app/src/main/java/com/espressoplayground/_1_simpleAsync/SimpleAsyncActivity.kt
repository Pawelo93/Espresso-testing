package com.espressoplayground._1_simpleAsync

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.espressoplayground.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_simple_async.*
import javax.inject.Inject

class SimpleAsyncActivity : AppCompatActivity(), SimpleAsyncView {

    @Inject
    lateinit var presenter: SimpleAsyncPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_async)

        presenter.bind(this)

        button.setOnClickListener {
            presenter.doAsyncTask()
        }
    }

    override fun showResult() {
        textView.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }
}
