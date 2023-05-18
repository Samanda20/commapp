package com.example.commapp.ui.util

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.commapp.repository.database.model.Coffee

class DiffItemCallBack: DiffUtil.ItemCallback<Coffee>() {
    override fun areItemsTheSame(oldItem: Coffee, newItem: Coffee): Boolean {
        var same = oldItem.id == newItem.id && oldItem.type == newItem.type
//        Log.d("diffutil", "items same, result:"+same+", id:"+oldItem.id+", name:"+oldItem.name)
        return same
    }

    override fun areContentsTheSame(oldItem: Coffee, newItem: Coffee): Boolean {
        var same = oldItem == newItem
//        var same = oldItem.id == newItem.id && oldItem.type == newItem.type
        if (!same) Log.d("diffutil", "contents same, result:"+same+", id:"+oldItem.id+", name:"+oldItem.name)
        return same
    }


}