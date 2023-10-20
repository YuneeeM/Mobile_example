package com.cookandroid.schoolapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.schoolapp.databinding.ItemRecyclerviewBinding

class CustomAdapter(val profileList : ArrayList<Profile>) : RecyclerView.Adapter<CustomAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  CustomAdapter.Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }


    override fun onBindViewHolder(holder: CustomAdapter.Holder, position: Int) {
        holder.num.text = profileList[position].num.toString()
        holder.content.text=profileList[position].content
    }

    override fun getItemCount(): Int {
       return profileList.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root){
        val num = binding.rvNum
        val content = binding.rvContent
    }
}