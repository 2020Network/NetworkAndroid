package com.example.studygorup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<View>(R.id.bottomNavigationView) as BottomNavigationView;
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nv_group -> {
                val fragmentGroup = GroupFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentGroup).commit()
            }
            R.id.nv_myPage -> {
                var fragmentMypage = NoticeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentMypage).commit()
            }
        }

        return true
    }
}