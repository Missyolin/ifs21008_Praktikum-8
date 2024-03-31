package com.ifs21008.pampraktikum8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.ifs21008.pampraktikum8.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    private lateinit var binding: FragmentNotificationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.vpFragmentNotification
        val pagerAdapter = NotificationPagerAdapter(requireActivity())
        viewPager.adapter = pagerAdapter
        pagerAdapter.info1 = "Notifikasi Belum Dibaca"
        pagerAdapter.info2 = "Notifikasi Sudah Dibaca"

        val tabs = binding.tabFragmentNotification
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]
        }.attach()
    }

    companion object {
        private val TAB_TITLES = arrayOf(
            "Belum Dibaca",
            "Sudah Dibaca",
        )
    }

}