package com.example.viewpagerapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewpagerapp.databinding.FragmentChildTwoBinding
import com.example.viewpagerapp.repository.UserRepository
import com.example.viewpagerapp.dataclass.JokeResponse
import com.example.viewpagerapp.dataclass.CategoryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class JokeViewModel(private val repository: UserRepository) : ViewModel() {


    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getJoke()
        }

        viewModelScope.launch(Dispatchers.IO) {
            repository.getCategories()
        }
    }

    val jokeData : LiveData<JokeResponse>
    get() = repository.data

    val categoryData : LiveData<CategoryResponse>
    get() = repository.categoryData

    val categoryJokeData : LiveData<JokeResponse>
    get() = repository.categoryJokeData


    fun refreshJoke(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getJoke()
        }
    }

    fun categoryJoke(category: String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCategoryJoke(category)
        }
    }
}