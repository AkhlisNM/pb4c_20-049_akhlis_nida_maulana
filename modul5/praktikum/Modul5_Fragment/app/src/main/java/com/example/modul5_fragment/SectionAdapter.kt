package com.example.modul5_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = AkademikFragment()
            1 -> fragment = UmumFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 2
    }


}