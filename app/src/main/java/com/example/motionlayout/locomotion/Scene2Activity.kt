package com.example.motionlayout.locomotion

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.motionlayout.R
import com.example.motionlayout.extentions.setLightStatusBar

class Scene2Activity : AppCompatActivity() {

    /**
     * Here android:elevation="6dp" in imageview plays much important role
     * To notice what role it plays run app by removing and adding it
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_2)

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