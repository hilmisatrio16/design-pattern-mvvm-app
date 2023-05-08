package com.example.designpatternmvvmapp.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.designpatternmvvmapp.databinding.ItemUserBinding
import com.example.designpatternmvvmapp.model.GetAllUserItem

class UserAdapter(private var listUser : List<GetAllUserItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(var binding : ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun itemBind(itemlist : GetAllUserItem){
            binding.user = itemlist
            Log.d("HASIL",itemlist.toString())
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.itemBind(listUser[position])
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    fun setList(list : List<GetAllUserItem>){
        listUser = list
    }
}