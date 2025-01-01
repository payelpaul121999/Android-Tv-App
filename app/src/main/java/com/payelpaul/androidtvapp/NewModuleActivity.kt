package com.payelpaul.androidtvapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.payelpaul.androidtvapp.databinding.ActivityNewModuleBinding
import com.payelpaul.androidtvapp.fragment.HomeFragment
import com.payelpaul.androidtvapp.fragment.MovieFragment
import com.payelpaul.androidtvapp.fragment.SearchFragment
import com.payelpaul.androidtvapp.fragment.SportFragment
import com.payelpaul.androidtvapp.fragment.TvShowFragment
import com.payelpaul.androidtvapp.modulle.CategoryFragment
import com.payelpaul.androidtvapp.modulle.LaunchFragment
import com.payelpaul.androidtvapp.modulle.ScreenNameAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewModuleActivity : FragmentActivity() {
    val items = arrayListOf("Home", "Categories", "Movie", "Shows", "Favourite")
private lateinit var binding : ActivityNewModuleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewModuleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerViewOfTab()
    }

    fun setRecyclerViewOfTab(){
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.tabRecyclerview.layoutManager = layoutManager
        val adapter = ScreenNameAdapter(items) { name ->
        when(name) {
            "Home"->{
                changeFragment(LaunchFragment())
            }
            "Categories"->{
                changeFragment(CategoryFragment())
            }
            "Movie"->{
                changeFragment(MovieFragment())
            }
            "Shows"->{
                changeFragment(TvShowFragment())
            }
            "Favourite"->{
                changeFragment(SportFragment())
            }
        }
        }
        binding.tabRecyclerview.adapter = adapter
    }
    fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerView, fragment)
        transaction.commit()

    }
}