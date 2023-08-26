package com.alpesh1.newsapp_api

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm: FragmentManager, fragments: Array<Fragment>, item: Array<String>) :
    FragmentPagerAdapter(fm) {

    var fragments = fragments
    var item = item
    override fun getCount(): Int {

        return fragments.size

    }

    override fun getItem(position: Int): Fragment {

        return fragments.get(position)

    }

    override fun getPageTitle(position: Int): CharSequence? {

        return item.get(position)

    }

}