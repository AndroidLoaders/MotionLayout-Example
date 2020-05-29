package com.example.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.motionlayout.extentions.setLightStatusBar

class Scene1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_1)

        setLightStatusBar()
    }
}