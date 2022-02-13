package com.example.viewpagerapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpagerapp.databinding.FragmentChildThreeBinding

class ChildFragmentThree : Fragment() {
    private var binding : FragmentChildThreeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val text : Int? = null
        binding = FragmentChildThreeBinding.inflate(layoutInflater)
        binding?.test?.text = text.toString()
        Log.i("test",text.toString())
        return  binding?.root
    }
}