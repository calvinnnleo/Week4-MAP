package com.example.week4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CafeFragment : Fragment() {

    companion object {
        private val TAB_TITLES_RESOURCES = arrayOf(
            R.string.starbucks_title,
            R.string.janjijiwa_title,
            R.string.kopikenangan_title
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        val cafeAdapter = CafeAdapter(this)
        viewPager.adapter = cafeAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(TAB_TITLES_RESOURCES[position])
        }.attach()
    }
}