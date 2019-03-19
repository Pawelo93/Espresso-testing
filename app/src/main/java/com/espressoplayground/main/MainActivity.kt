package com.espressoplayground.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.espressoplayground.R
import com.espressoplayground.apiRequest.ApiRequestActivity
import com.espressoplayground.simpleAsync.SimpleAsyncActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simpleAsyncButton.setOnClickListener {
            startActivity(Intent(this, SimpleAsyncActivity::class.java))
        }

        apiRequestButton.setOnClickListener {
            startActivity(Intent(this, ApiRequestActivity::class.java))
        }
    }
}
