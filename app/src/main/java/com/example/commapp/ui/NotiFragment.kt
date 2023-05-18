package com.example.commapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.commapp.R
import com.example.commapp.databinding.FragmentNotiBinding
import com.example.commapp.repository.database.model.Coffee
import com.example.commapp.repository.database.model.FavoriteCoffee
import com.example.commapp.viewmodel.MainViewModel
import com.example.commapp.viewmodel.NotiViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotiFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel: NotiViewModel by activityViewModels()
    private lateinit var binding : FragmentNotiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_noti, container, false)
        binding.lifecycleOwner = requireActivity()
        binding.viewmodel = viewModel

        return binding.root
    }

    object BindingItem {
        @JvmStatic
        @BindingAdapter("notiItem")
        fun notiItem(view: RecyclerView, list: List<FavoriteCoffee>?) {

            val recyclerAdapter = if (view.adapter == null) NotiRecyclerAdapter() else view.adapter as NotiRecyclerAdapter
            recyclerAdapter.apply { view.adapter = this }

            list?.let { recyclerAdapter.updateNotiList(list) }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NotiFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}