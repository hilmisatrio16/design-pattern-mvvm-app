package com.example.designpatternmvvmapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.designpatternmvvmapp.model.GetAllUserItem
import com.example.designpatternmvvmapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {
    lateinit var liveDataUser : MutableLiveData<List<GetAllUserItem>>

    init {
        liveDataUser = MutableLiveData()
    }

    fun callApiDataUser(){
        ApiClient.instance.getAllUser().enqueue(
            object : Callback<List<GetAllUserItem>>{
                override fun onResponse(
                    call: Call<List<GetAllUserItem>>,
                    response: Response<List<GetAllUserItem>>
                ) {
                    if(response.isSuccessful){
                        liveDataUser.postValue(response.body())
                    }else{
                        liveDataUser.postValue(null)
                        Log.d("NULL_OUT", response.body().toString())
                    }
                }

                override fun onFailure(call: Call<List<GetAllUserItem>>, t: Throwable) {
                    liveDataUser.postValue(null)
                    Log.d("TROWABLE", t.message!!)
                }

            }
        )
    }


}