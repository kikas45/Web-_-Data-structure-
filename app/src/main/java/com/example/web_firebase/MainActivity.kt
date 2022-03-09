package com.example.web_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.web_firebase.frgaments.Grid
import com.example.web_firebase.frgaments.Home
import com.google.android.material.tabs.TabLayout
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.getReference("message")

        setuptab()
    }

    private fun setuptab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Grid(), title = "")
        adapter.addFragment(Home(), title = "")


        ////

        val com_viewPager = findViewById<ViewPager>(R.id.custom_viewpager)
        com_viewPager.adapter = adapter

        com_viewPager.offscreenPageLimit = 4

        val tabs = findViewById<TabLayout>(R.id.tabs)
        tabs.setupWithViewPager(com_viewPager)

        ////add the titles

          tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_home_24)
    }
    }