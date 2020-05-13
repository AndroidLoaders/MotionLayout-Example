package com.example.motionlayout

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMotionScene1.setOnClickListener(this)
        btnMotionScene2.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnMotionScene1 -> startActivity(MotionScene1::class.java)
            R.id.btnMotionScene2 -> startActivity(MotionScene2::class.java)
            else -> {
            }
        }
    }

    private fun <T : AppCompatActivity> startActivity(target: Class<T>) =
        startActivity(Intent(this, target))
}