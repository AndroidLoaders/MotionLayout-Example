package com.example.motionlayout.extentions

import android.view.View
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.setLightStatusBar(){
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    var flags = window.decorView.systemUiVisibility
    flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    window.decorView.systemUiVisibility = flags
}