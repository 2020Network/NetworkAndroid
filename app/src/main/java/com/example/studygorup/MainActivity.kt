package com.example.studygorup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private val fragmentmyPage : MypageFragmentKt = MypageFragmentKt()
    private val fragmentGroup : GroupFragmentKt = GroupFragmentKt()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<View>(R.id.bottomNavigationView) as BottomNavigationView;
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        val bundle = Bundle()
        bundle.putInt("userID", intent.getIntExtra("userID",0))
        fragmentGroup.arguments = bundle
        fragmentmyPage.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragmentGroup).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //fragment 이동
        when(item.itemId){
            R.id.nv_group -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentGroup).commit()
            }
            R.id.nv_myPage -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentmyPage).commit()
            }
        }

        return true
    }
}