package com.example.mvvmproject.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import com.example.mvvmproject.R
import com.example.mvvmproject.widget.extension.startActivityWithFinish
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.github.appintro.AppIntroPageTransformerType


class appIntroActivity : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addSlide(AppIntroFragment.newInstance(
            description = "여러 사람과 함께 하는 공부 \n\n같이 공부할 사람을 모집합니다.",
            imageDrawable = R.drawable.intro1,
            descriptionColor = Color.WHITE,
            backgroundColor = Color.parseColor("#3F8E8F"),
            titleTypefaceFontRes = R.font.appleneob,
            descriptionTypefaceFontRes = R.font.appleneob
        ))
        addSlide(AppIntroFragment.newInstance(
            description = "채팅을 사용해서 \n\n공부한 내용을 공유합니다.",
            imageDrawable = R.drawable.intro2,
            descriptionColor = Color.WHITE,
            backgroundColor = Color.parseColor("#3F8E8F"),
            titleTypefaceFontRes = R.font.appleneob,
            descriptionTypefaceFontRes = R.font.appleneob
        ))
        addSlide(AppIntroFragment.newInstance(
            description = "스터디 모임 \n\n함께 공부할 장소를 정합니다.",
            imageDrawable = R.drawable.intro3,
            descriptionColor = Color.WHITE,
            backgroundColor = Color.parseColor("#3F8E8F"),
            titleTypefaceFontRes = R.font.appleneob,
            descriptionTypefaceFontRes = R.font.appleneob
        ))

        setTransformer(AppIntroPageTransformerType.Depth)
        setProgressIndicator()
        indicatorController!!.selectedIndicatorColor = Color.parseColor("#FFFFFF")
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        startActivityWithFinish(applicationContext, MainActivity::class.java)
        /*startActivity(Intent(applicationContext, MainActivity::class.java))*/
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)

        startActivityWithFinish(applicationContext, MainActivity::class.java)
    }
}