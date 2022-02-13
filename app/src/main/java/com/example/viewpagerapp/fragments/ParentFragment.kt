package com.example.viewpagerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpagerapp.adapters.ViewPagerAdapter
import com.example.viewpagerapp.databinding.FragmentParentBinding
import com.google.android.material.tabs.TabLayoutMediator

class ParentFragment : Fragment() {
    private var binding : FragmentParentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentParentBinding.inflate(layoutInflater)
        setUpTabs()
        return  binding?.root
    }
    fun setUpTabs(){
        val fragmentList = arrayListOf<Fragment>(
            ChildFragmentOne(),
            ChildFragmentTwo(),
            ChildFragmentThree()
        )
        val adapter = ViewPagerAdapter(fragmentList,childFragmentManager,lifecycle)
        binding?.actionBarViewPager?.adapter = adapter

        TabLayoutMediator(binding?.actionBarTabLayout!!, binding?.actionBarViewPager!!) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()

        binding?.actionBarTabLayout?.getTabAt(0)!!.text = "Random"
        binding?.actionBarTabLayout?.getTabAt(1)!!.text = "Category"
        binding?.actionBarTabLayout?.getTabAt(2)!!.text = "Links"

    }


}