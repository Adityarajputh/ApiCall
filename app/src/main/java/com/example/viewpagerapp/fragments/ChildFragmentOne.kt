package com.example.viewpagerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewpagerapp.networkLayer.ChuckNorrisService
import com.example.viewpagerapp.networkLayer.NetworkInstance
import com.example.viewpagerapp.repository.UserRepository
import com.example.viewpagerapp.databinding.FragmentChildOneBinding
import com.example.viewpagerapp.dataclass.JokeResponse
import com.example.viewpagerapp.viewModel.JokeViewModel
import com.example.viewpagerapp.viewModel.JokeViewModelFactory

class ChildFragmentOne : Fragment() {
    private var binding : FragmentChildOneBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChildOneBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val apiInterface = NetworkInstance.getInstance().create(ChuckNorrisService::class.java)
        val repository = UserRepository(apiInterface)

        val viewModel = ViewModelProvider(this, JokeViewModelFactory(repository))
                        .get(JokeViewModel::class.java)

        viewModel.jokeData.observe(viewLifecycleOwner, Observer { condition ->
            checkProgressBar(condition)
            binding?.jokeText?.text = condition.value
            binding?.refreshBtn?.setOnClickListener {
                checkProgressBar(condition)
                viewModel.refreshJoke()
            }
        })


    }
    private fun checkProgressBar(it: JokeResponse?) {
        if(it != null){
            binding?.progressBar?.visibility = View.GONE
        }
    }

}