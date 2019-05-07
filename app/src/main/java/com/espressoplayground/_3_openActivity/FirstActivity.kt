package com.espressoplayground._3_openActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.espressoplayground.R
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        openSecondActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", "Wacek")
            startActivity(intent)
        }
    }
}
