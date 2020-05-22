package com.example.motionlayout

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.transition.AutoTransition
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.activity_loco_motion.*

class LocoMotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loco_motion)

        tvSceneTitle1.setOnClickListener {
            if (it.isClickable) {
                it.isClickable = false
                animateLayoutItems(ivMotionScene1, cardScene1, llCardItems1, tvSceneTitle1)
                if (tvSceneTitle2.isSelected) {
                    animateLayoutItems(ivMotionScene2, cardScene2, llCardItems2, tvSceneTitle2)
                    tvSceneTitle2.isSelected = false
                }
                it.isSelected = true
            }
        }
        tvSceneTitle2.setOnClickListener {
            if (it.isClickable) {
                it.isClickable = false
                animateLayoutItems(ivMotionScene2, cardScene2, llCardItems2, tvSceneTitle2)
                if (tvSceneTitle1.isSelected) {
                    animateLayoutItems(ivMotionScene1, cardScene1, llCardItems1, tvSceneTitle1)
                    tvSceneTitle1.isSelected = false
                }
                it.isSelected = true
            }
        }
    }

    private fun animateLayoutItems(
        ivImage: ImageView, cardView: MaterialCardView, linearLayout: LinearLayout,
        textView: TextView
    ) {
        ivImage.animate().apply {
            this.duration = 350
            this.rotation(ivMotionScene1.rotation + 180).start()
        }

        TransitionManager.beginDelayedTransition(cardView, AutoTransition().apply {
            this.duration = 500
            this.interpolator = FastOutSlowInInterpolator()
            this.addListener(object : Transition.TransitionListener {
                override fun onTransitionStart(transition: Transition) {
                }

                override fun onTransitionResume(transition: Transition) {

                }

                override fun onTransitionPause(transition: Transition) {
                }

                override fun onTransitionCancel(transition: Transition) {

                }

                override fun onTransitionEnd(transition: Transition) {
                    linearLayout.visibility =
                        if (linearLayout.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                    textView.isClickable = true
                }
            })
        })
    }
}