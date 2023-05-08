package com.example.designpatternmvvmapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.designpatternmvvmapp.R
import com.example.designpatternmvvmapp.databinding.ActivityMainBinding
import com.example.designpatternmvvmapp.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userAdapter = UserAdapter(ArrayList())
        setRecyclerview()
    }

    private fun setRecyclerview() {

        userViewModel.callApiDataUser()

        userViewModel.liveDataUser.observe(this, Observer {
           if(it != null){
               Log.d("HASIL_OUT", it.toString())
               binding.rvUser.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
               binding.rvUser.adapter = userAdapter
               userAdapter.setList(it)
           }else{
               Log.d("HASIL_OUT", it.toString())
           }
        })


    }
}