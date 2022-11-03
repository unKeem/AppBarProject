package com.example.appbarproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdabter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    var fragmentList = ArrayList<Fragment>()
    val tilteList = ArrayList<String>()

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    fun addFragment(fragment: Fragment,title:String) {
        fragmentList.add(fragment)
        tilteList.add(title)
    }
}