package com.example.motionlayout.locomotion

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.motionlayout.R
import com.example.motionlayout.extentions.setLightStatusBar

class Scene1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_1)

        supportActionBar?.run {
            this.setDisplayHomeAsUpEnabled(true)
        }

        setLightStatusBar()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}