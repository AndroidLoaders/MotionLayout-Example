package com.example.motionlayout.locomotion.motionscene2

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.motionlayout.R
import com.example.motionlayout.extentions.setLightStatusBar
import kotlinx.android.synthetic.main.activity_scene_6.*

class Scene6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_6)

        supportActionBar?.run {
            this.setDisplayHomeAsUpEnabled(true)
        }

        setLightStatusBar()

        initTopStartImageAnimations()
        initBottomEndImageAnimations()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    private fun initTopStartImageAnimations() {
        val topStartForwardAnimator =
            AnimatedVectorDrawableCompat.create(this, R.drawable.top_start_liquid_forward)
        val topStartReverseAnimator =
            AnimatedVectorDrawableCompat.create(this, R.drawable.top_start_liquid_reverse)

        topStartForwardAnimator?.run {
            this.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    ivTopStartLiquid.setImageDrawable(topStartReverseAnimator)
                    topStartReverseAnimator?.start()
                }
            })
        }

        topStartReverseAnimator?.run {
            this.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    ivTopStartLiquid.setImageDrawable(topStartForwardAnimator)
                    topStartForwardAnimator?.start()
                }
            })
        }

        topStartForwardAnimator?.start()
    }

    private fun initBottomEndImageAnimations() {
        val bottomEndForwardAnimator =
            AnimatedVectorDrawableCompat.create(this, R.drawable.bottom_end_liquid_forward)
        val bottomEndReverseAnimator =
            AnimatedVectorDrawableCompat.create(this, R.drawable.bottom_end_liquid_reverse)

        bottomEndForwardAnimator?.run {
            this.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    ivBottomEndLiquid.setImageDrawable(bottomEndReverseAnimator)
                    bottomEndReverseAnimator?.start()
                }
            })
        }

        bottomEndReverseAnimator?.run {
            this.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    ivBottomEndLiquid.setImageDrawable(bottomEndForwardAnimator)
                    bottomEndForwardAnimator?.start()
                }
            })
        }

        bottomEndForwardAnimator?.start()
    }
}