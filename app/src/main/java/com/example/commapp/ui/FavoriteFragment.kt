package com.example.commapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.commapp.R
import com.example.commapp.databinding.FragmentFavoriteBinding
import com.example.commapp.repository.database.model.Coffee
import com.example.commapp.viewmodel.MainViewModel

class FavoriteFragment : Fragment(), OnItemClick {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false)
        binding.lifecycleOwner = requireActivity()
        binding.viewmodel = viewModel
        (binding.recyclerViewFav.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        (binding.recyclerViewFav.adapter as CoffeeRecyclerAdapter).setItemClickListener(this)

        return binding.root
    }

    override fun favorite(id: Int, type: String) {
        viewModel.changeFavorite(id, type)
    }

    override fun goDetail(id: Int, type: String) {

    }

    object BindingItem {
        @JvmStatic
        @BindingAdapter("itemFav")
        fun setItem(view: RecyclerView, list: List<Coffee>?) {

            val recyclerViewAdapter = if (view.adapter == null) CoffeeRecyclerAdapter() else view.adapter as CoffeeRecyclerAdapter
            if (view.adapter == null) view.adapter = recyclerViewAdapter

            list?.let {
                Log.d("binding adapter FAV", "update list")
//                val save = view.layoutManager?.onSaveInstanceState()
                recyclerViewAdapter.submitList(it.filter { coffee -> coffee.favorite })
//                view.layoutManager?.onRestoreInstanceState(save)
            }
        }
    }


}