package com.example.viewpagerapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpagerapp.databinding.ActivityMainBinding
import com.example.viewpagerapp.fragments.ParentFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.supportFragmentManager.beginTransaction()
            .replace(R.id.appContainer,ParentFragment())
            .commit()

    }
//    override fun dialogInterface(categoryName: String) {
//        val apiInterface = NetworkInstance.getInstance().create(ChuckNorrisService::class.java)
//        val repository = UserRepository(apiInterface)
//
//        val viewModel = ViewModelProvider(this, JokeViewModelFactory(repository))
//            .get(JokeViewModel::class.java)
//
//        viewModel.categoryJoke(categoryName)
//
//    }
}