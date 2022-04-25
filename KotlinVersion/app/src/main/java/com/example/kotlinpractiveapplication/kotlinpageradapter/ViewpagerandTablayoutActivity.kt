package com.example.kotlinpractiveapplication.kotlinpageradapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlinpractiveapplication.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewpagerandTablayoutActivity : AppCompatActivity() {
    lateinit var viewPager2: ViewPager2
    lateinit var tabLayout: TabLayout
    lateinit var viewpageandTablayoutAdapter: ViewpageandTablayoutAdapter
    var fragments = listOf<Fragment>(FirstFragment(), SecondFragment(), ThirdFragment())
    var titles = listOf<String>("First", "Second", "Third")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpagerand_tablayout)
        viewPager2 = findViewById(R.id.id_viewpager2)
        tabLayout = findViewById(R.id.id_tablayout)
        viewpageandTablayoutAdapter =
            ViewpageandTablayoutAdapter(this, fragments)
        viewPager2.adapter = viewpageandTablayoutAdapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = titles[position]
        }.attach()


    }


}