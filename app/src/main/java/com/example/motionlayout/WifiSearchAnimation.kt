package com.example.motionlayout

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_wifi_search.*


class WifiSearchAnimation : AppCompatActivity() {

    /**
     * For more details go through official link :
     * https://developer.android.com/reference/android/graphics/drawable/AnimationDrawable
     *
     * Important : You can not start/stop animation-list in onCreate.Operation must be performed
     * within click listener or ni Runnable
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi_search)

        btnAnimate.setOnClickListener {
            ivImage.background?.run {
                if (this is AnimationDrawable) {
                    if (ivImage.tag == getString(R.string.start_animation)) {
                        ivImage.tag = getString(R.string.stop_animation)
                        this.start()
                    } else {
                        ivImage.tag = getString(R.string.start_animation)
                        this.stop()
                    }
                }
            }
        }
    }
}