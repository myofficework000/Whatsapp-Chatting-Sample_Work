package com.example.whatsappfeatureapp.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.whatsappfeatureapp.view.fragment.CallFragment
import com.example.whatsappfeatureapp.view.fragment.CameraFragment
import com.example.whatsappfeatureapp.view.fragment.ChatFragment
import com.example.whatsappfeatureapp.view.fragment.StatusFragment

class TabLayoutAdapter (
    fragment: Fragment
): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4
    override fun createFragment(position: Int): Fragment = when(position) {
        0 -> CameraFragment()
        1 -> ChatFragment()
        2 -> CallFragment()
        3 -> StatusFragment()
        else -> throw java.lang.IllegalStateException()
    }
}