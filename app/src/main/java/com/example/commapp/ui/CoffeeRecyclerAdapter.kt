package com.example.commapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.commapp.R
import com.example.commapp.databinding.ListItemBinding
import com.example.commapp.repository.database.model.Coffee
import com.example.commapp.ui.util.DiffItemCallBack
import com.example.commapp.ui.util.GlideApp

class CoffeeRecyclerAdapter() : ListAdapter<Coffee, CoffeeRecyclerAdapter.CoffeeViewHolder>(DiffItemCallBack()) {
//class CoffeeRecyclerAdapter : RecyclerView.Adapter<CoffeeRecyclerAdapter.CoffeeViewHolder>() {

    //    private var itemList = ArrayList<Coffee>()
    private var removePosition = -1
    private lateinit var onItemClick: OnItemClick
    fun setItemClickListener(listener: OnItemClick) {
        onItemClick = listener
    }

    class CoffeeViewHolder(itemView: View) : ViewHolder(itemView) {
        val binding = DataBindingUtil.bind<ListItemBinding>(itemView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder =
        CoffeeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.binding?.let {

            it.item = getItem(position)
            holder.apply {
                GlideApp.with(it.root.context).load(getItem(position).image).into(it.image)
            }
            it.favorite.setOnClickListener {
                onItemClick.favorite(getItem(position).id, getItem(position).type)
                removePosition = holder.adapterPosition
            }
            it.listMainLayout.setOnClickListener {
                onItemClick.goDetail(getItem(position).id, getItem(position).type) }
        }
    }

    override fun onCurrentListChanged(
        previousList: MutableList<Coffee>,
        currentList: MutableList<Coffee>
    ) {
        if (previousList.size != currentList.size && removePosition != -1) {
//            notifyItemRangeChanged(removePosition, currentList.size-removePosition)
            notifyItemRangeChanged(0, currentList.size)
            removePosition = -1
        }
        super.onCurrentListChanged(previousList, currentList)
    }
}