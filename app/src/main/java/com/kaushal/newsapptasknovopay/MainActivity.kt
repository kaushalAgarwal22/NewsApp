package com.kaushal.newsapptasknovopay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaushal.newsapptasknovopay.Adapter.ViewPagerAdapter
import com.kaushal.newsapptasknovopay.Fragments.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            setupViewPager()

    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment( "Business",FirstFragment())
        adapter.addFragment( "Entertainment",EntertainmentFragment())
        adapter.addFragment( "Health",ThirdFragment())
        adapter.addFragment( "Science",FourthFragment())
        adapter.addFragment( "Sports",FifthFragment())
        adapter.addFragment( "Technology",SixthFragment())
        adapter.addFragment( "US News",SeventhFragment())
        adapter.addFragment( "UK News",EightFragment())
        adapter.addFragment( "Australia News",NinethFragment())
        adapter.addFragment( "Canada News",TenFragment())
        viewpager.adapter = adapter
        tabs?.setupWithViewPager(viewpager)

    }


}
