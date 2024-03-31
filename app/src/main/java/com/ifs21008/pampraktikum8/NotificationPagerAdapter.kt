package com.ifs21008.pampraktikum8

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class NotificationPagerAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    var info1 = ""
    var info2 = ""

    override fun createFragment(position: Int): Fragment {
        val fragment = DetailFragment()
        fragment.arguments = Bundle().apply {
            when (position) {
                0 -> putString(DetailFragment.EXTRA_INFO, info1)
                1 -> putString(DetailFragment.EXTRA_INFO, info2)
            }
        }
        return fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}