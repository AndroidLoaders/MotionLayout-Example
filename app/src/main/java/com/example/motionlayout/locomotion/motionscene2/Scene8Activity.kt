package com.example.motionlayout.locomotion.motionscene2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.motionlayout.R
import com.example.motionlayout.extentions.setLightStatusBar

class Scene8Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_8)

        setLightStatusBar()
    }
}