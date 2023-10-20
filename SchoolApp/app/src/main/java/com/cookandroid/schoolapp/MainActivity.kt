package com.cookandroid.schoolapp

import android.R
import android.os.Bundle
import android.view.Menu
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var frameLayout: FrameLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.cookandroid.schoolapp.R.layout.activity_main)

        frameLayout = findViewById(com.cookandroid.schoolapp.R.id.frameLayout)

        tabLayout = findViewById(com.cookandroid.schoolapp.R.id.tabLayout)

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab!!.position) {
                    0 ->{
                        val fragment = Fragment1()
                        transaction.replace(com.cookandroid.schoolapp.R.id.frameLayout, fragment)
                    }

                    1 ->{
                        val fragment = Fragment2()
                        transaction.replace(com.cookandroid.schoolapp.R.id.frameLayout, fragment)
                    }
                    2 -> {
                        val fragment = Fragment3()
                        transaction.replace(com.cookandroid.schoolapp.R.id.frameLayout, fragment)
                    }
                    3 -> {
                        val fragment = Fragment4()
                        transaction.replace(com.cookandroid.schoolapp.R.id.frameLayout, fragment)
                    }
                    4 -> {
                        val fragment = Fragment5()
                        transaction.replace(com.cookandroid.schoolapp.R.id.frameLayout, fragment)
                    }
                }
                transaction.commit() // 트랜잭션을 커밋하여 Fragment를 추가 및 실행
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(com.cookandroid.schoolapp.R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }


}