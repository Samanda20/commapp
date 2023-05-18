package com.example.commapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.commapp.databinding.LayoutItemBinding
import com.example.commapp.repository.database.model.FavoriteCoffee
import com.example.commapp.ui.model.Notification

class NotiRecyclerAdapter : RecyclerView.Adapter<NotiRecyclerAdapter.NotiViewHolder>() {
    private var notiList = ArrayList<FavoriteCoffee>()
    private lateinit var binding: LayoutItemBinding

    fun updateNotiList(list: List<FavoriteCoffee>) {
        notiList.clear()
        notiList.addAll(list)
        notifyDataSetChanged()
    }

    class NotiViewHolder(binding: LayoutItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotiViewHolder {
        binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return NotiViewHolder(binding)
    }

    override fun getItemCount(): Int = notiList.size

    override fun onBindViewHolder(holder: NotiViewHolder, position: Int) {
        binding.item = notiList[position]
    }
}