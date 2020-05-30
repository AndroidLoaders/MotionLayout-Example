package com.example.motionlayout.locomotion

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.example.motionlayout.R
import com.example.motionlayout.locomotion.motionscene1.*
import com.example.motionlayout.locomotion.motionscene2.Scene6Activity
import com.example.motionlayout.locomotion.motionscene2.Scene7Activity
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.activity_loco_motion.*

class LocoMotionActivity : AppCompatActivity(), View.OnClickListener {

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loco_motion)

        supportActionBar?.run {
            this.setDisplayHomeAsUpEnabled(true)
        }

        initViews()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    private fun initViews() {
        tvSceneTitle1.setOnClickListener(this)
        tvSceneTitle2.setOnClickListener(this)

        btnScene1.setOnClickListener(this)
        btnScene2.setOnClickListener(this)
        btnScene3.setOnClickListener(this)
        btnScene4.setOnClickListener(this)
        btnScene5.setOnClickListener(this)
        btnScene6.setOnClickListener(this)
        btnScene7.setOnClickListener(this)
        btnScene8.setOnClickListener(this)
        btnScene9.setOnClickListener(this)
        btnScene10.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvSceneTitle1 -> {
                var isOtherItemVisible = false
                if (expendableItems2.visibility == View.VISIBLE) {
                    isOtherItemVisible = true
                    animateLayoutItems(ivMotionScene2, cardScene2, expendableItems2)
                }
                if (isOtherItemVisible)
                    handler.postDelayed({
                        animateLayoutItems(ivMotionScene1, cardScene1, expendableItems1)
                    }, 800)
                else
                    animateLayoutItems(ivMotionScene1, cardScene1, expendableItems1)
            }
            R.id.tvSceneTitle2 -> {
                var isOtherItemVisible = false
                if (expendableItems1.visibility == View.VISIBLE) {
                    isOtherItemVisible = true
                    animateLayoutItems(ivMotionScene1, cardScene1, expendableItems1)
                }

                if (isOtherItemVisible)
                    handler.postDelayed({
                        animateLayoutItems(ivMotionScene2, cardScene2, expendableItems2)
                    }, 800)
                else animateLayoutItems(ivMotionScene2, cardScene2, expendableItems2)
            }
            R.id.btnScene1 -> startNewActivity(Scene1Activity::class.java)
            R.id.btnScene2 -> startNewActivity(Scene2Activity::class.java)
            R.id.btnScene3 -> startNewActivity(Scene3Activity::class.java)
            R.id.btnScene4 -> startNewActivity(Scene4Activity::class.java)
            R.id.btnScene5 -> startNewActivity(Scene5Activity::class.java)
            R.id.btnScene6 -> startNewActivity(Scene6Activity::class.java)
            R.id.btnScene7 -> startNewActivity(Scene7Activity::class.java)
        }
    }

    private fun animateLayoutItems(
        ivImage: ImageView, cardView: MaterialCardView, expendableLayout: ConstraintLayout
    ) {
        TransitionManager.beginDelayedTransition(cardView, AutoTransition())
        expendableLayout.visibility = if (expendableLayout.visibility == View.GONE) View.VISIBLE
        else View.GONE
        ivImage.animate().apply {
            this.duration = 350
            this.rotation(ivImage.rotation + 180).start()
        }
    }

    private fun <T : AppCompatActivity> startNewActivity(target: Class<T>) =
        startActivity(Intent(this, target))
}