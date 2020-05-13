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
        btnMotionScene3.setOnClickListener(this)
        btnMotionScene4.setOnClickListener(this)
        btnMotionScene5.setOnClickListener(this)
        btnMotionScene6.setOnClickListener(this)
        btnMotionScene7.setOnClickListener(this)
        btnMotionScene8.setOnClickListener(this)
        btnMotionScene9.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnMotionScene1 -> startActivity(MotionScene1::class.java)
            R.id.btnMotionScene2 -> startActivity(MotionScene2::class.java)
            R.id.btnMotionScene3 -> startActivity(MotionScene3::class.java)
            R.id.btnMotionScene4 -> startActivity(MotionScene4::class.java)
            R.id.btnMotionScene5 -> startActivity(MotionScene5::class.java)
            R.id.btnMotionScene6 -> startActivity(MotionScene6::class.java)
            R.id.btnMotionScene7 -> startActivity(MotionScene7::class.java)
            R.id.btnMotionScene8 -> startActivity(MotionScene8::class.java)
            R.id.btnMotionScene9 -> startActivity(MotionScene9::class.java)
            else -> {
            }
        }
    }

    private fun <T : AppCompatActivity> startActivity(target: Class<T>) =
        startActivity(Intent(this, target))
}