package com.example.week4

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CafeAdapter(private val parentFragment: Fragment) : FragmentStateAdapter(parentFragment) {

    companion object {
        private val TABS_DESCRIPTIONS_RESOURCES = arrayOf(
            R.string.starbucks_desc,
            R.string.janjijiwa_desc,
            R.string.kopikenangan_desc
        )
    }

    override fun getItemCount(): Int {
        return TABS_DESCRIPTIONS_RESOURCES.size
    }

    override fun createFragment(position: Int): Fragment {
        val descriptionResId = TABS_DESCRIPTIONS_RESOURCES[position]
        val description = parentFragment.requireContext().getString(descriptionResId)
        return CafeDetailFragment.newInstance(description)
    }
}