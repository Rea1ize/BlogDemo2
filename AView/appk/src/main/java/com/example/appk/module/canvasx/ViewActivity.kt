package com.example.appk.module.canvasx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.appk.R

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        val xView=XView(this)
    }
}