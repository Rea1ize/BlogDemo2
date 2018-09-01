
package com.example.tonjies.jrebel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mText.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        })
    }
}
