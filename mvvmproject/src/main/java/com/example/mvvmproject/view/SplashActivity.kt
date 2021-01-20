package com.example.mvvmproject.view

import android.content.Intent
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.UiThread
import com.example.mvvmproject.R
import com.example.mvvmproject.base.BaseActivity
import com.example.mvvmproject.databinding.ActivitySplashBinding
import com.example.mvvmproject.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>() {
    override val resource: Int
        get() = R.layout.activity_splash
    override val viewModel: SplashViewModel
        get() = getViewModel(SplashViewModel::class)

    override fun init() {
        splashanim()
    }

    override fun observerViewModel() {
        /*val handler = Handler()
        var runnable: Runnable

        with(viewModel) {
            onSuccessEvent.observe(this@SplashActivity, {
                runnable = Runnable {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                }
                handler.postDelayed(runnable, 2000)
            })

        }*/
    }

    @UiThread
    private fun splashanim(){
        val textAnim : Animation = AnimationUtils.loadAnimation(this@SplashActivity,R.anim.anim_splash_textview)
        val splashTextView = findViewById<TextView>(R.id.splashTextView)
        splashTextView.startAnimation(textAnim)

        val imageAnim : Animation = AnimationUtils.loadAnimation(this@SplashActivity,R.anim.anim_splash_imageview)
        val splashImageView = findViewById<ImageView>(R.id.splashImageView)
        splashImageView.startAnimation(imageAnim)

        imageAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {
                val intent = Intent(this@SplashActivity, appIntroActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.anim_splash_out_top, R.anim.anim_splash_in_down)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation) {
            }

        })
    }
}