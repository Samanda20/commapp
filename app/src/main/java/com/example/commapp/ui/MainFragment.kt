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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.commapp.MainActivity
import com.example.commapp.R
import com.example.commapp.databinding.FragmentMainBinding
import com.example.commapp.repository.database.model.Coffee
import com.example.commapp.viewmodel.MainViewModel

class MainFragment : Fragment(), OnItemClick {
    val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = requireActivity()
        binding.viewmodel = viewModel
        (binding.recyclerView.adapter as CoffeeRecyclerAdapter).setItemClickListener(this)
        val animator = binding.recyclerView.itemAnimator
        if (animator is SimpleItemAnimator) animator.supportsChangeAnimations = false

        return binding.root
    }

    override fun favorite(id: Int, type: String) {
        viewModel.changeFavorite(id, type)
    }

    override fun goDetail(id: Int, type: String) {

    }

    object BindingItem {
        @JvmStatic
        @BindingAdapter("item")
        fun setItem(view: RecyclerView, list: List<Coffee>?) {

            val recyclerViewAdapter = if (view.adapter == null) CoffeeRecyclerAdapter() else view.adapter as CoffeeRecyclerAdapter
            if (view.adapter == null) view.adapter = recyclerViewAdapter

            list?.let {
                Log.d("binding adapter", "update list")
                val save = view.layoutManager?.onSaveInstanceState()
                recyclerViewAdapter.submitList(it)
                view.layoutManager?.onRestoreInstanceState(save)}
        }

    }
}