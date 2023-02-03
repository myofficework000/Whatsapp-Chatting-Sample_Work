package com.example.whatsappfeatureapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatsappfeatureapp.R
import com.example.whatsappfeatureapp.databinding.FragmentTabLayoutMainBinding
import com.example.whatsappfeatureapp.view.adapter.TabLayoutAdapter
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutMainFragment : Fragment() {
    private lateinit var binding: FragmentTabLayoutMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentTabLayoutMainBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainViewPager.adapter = TabLayoutAdapter(this)
        TabLayoutMediator(binding.mainTabLayout, binding.mainViewPager) { tab, pos ->
            tab.text = when (pos) {
                0 -> ""
                1 -> getString(R.string.tabLayoutTitle_Chat)
                2 -> getString(R.string.tabLayoutTitle_Call)
                3 -> getString(R.string.tabLayoutTitle_Status)
                else -> ""
            }
            if (pos == 0) tab.setIcon(R.drawable.baseline_camera_alt_24)
        }.attach()

        binding.mainViewPager.setCurrentItem(1, false)
    }

}