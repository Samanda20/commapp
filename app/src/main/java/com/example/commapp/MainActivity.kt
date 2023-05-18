package com.example.commapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.commapp.databinding.ActivityMainBinding
import com.example.commapp.ui.FavoriteFragment
import com.example.commapp.ui.MainFragment
import com.example.commapp.ui.NotiFragment
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class MainActivity : AppCompatActivity() {
//    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private val tabList = listOf("Favorite", "Community", "Notifications")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewPager.adapter = TabPagerAdapter(this)
        binding.viewPager.setCurrentItem(1, false);

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }

    inner class TabPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when(position) {
                0 -> FavoriteFragment()
                1 -> MainFragment()
                else -> NotiFragment()
            }
        }
    }
}