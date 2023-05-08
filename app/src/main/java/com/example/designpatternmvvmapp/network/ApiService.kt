package com.example.designpatternmvvmapp.network

import com.example.designpatternmvvmapp.model.GetAllUserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("user")
    fun getAllUser() : Call<List<GetAllUserItem>>

}