package com.example.viewpagerapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.viewpagerapp.dataclass.CategoryResponse
import com.example.viewpagerapp.dataclass.JokeResponse
import com.example.viewpagerapp.networkLayer.ChuckNorrisService
import retrofit2.http.Query

class UserRepository(private val chuckNorrisService: ChuckNorrisService){

    private val myLiveData = MutableLiveData<JokeResponse>()
    private val myCategoryLiveData = MutableLiveData<CategoryResponse>()
    private val myJokeLiveData = MutableLiveData<JokeResponse>()


    val data: LiveData<JokeResponse>
        get() = myLiveData

    val categoryData : LiveData<CategoryResponse>
        get() = myCategoryLiveData

    val categoryJokeData : LiveData<JokeResponse>
        get() = myJokeLiveData

    suspend fun getJoke(){
        val result = chuckNorrisService.getJoke()
        if(result.body()!= null){
            myLiveData.postValue(result.body())
        }
    }

    suspend fun getCategories(){
        val category = chuckNorrisService.getCategories()
        if(category.body() != null){
            myCategoryLiveData.postValue(category.body())
        }
    }

    suspend fun getCategoryJoke(category : String){
        val categoryJoke = chuckNorrisService.getCategoryJoke(category)
        if(categoryJoke.body() != null){
            myJokeLiveData.postValue(categoryJoke.body())
        }
    }
}