package com.payelpaul.androidtvapp.modulle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.payelpaul.androidtvapp.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!
    val itemCategory = arrayListOf("Action", "Drama", "Comedy", "Fantasy", "Horror","Romance","Documentary","Animation","Thriller","Adventure")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        setRecyclerViewOfTab()
        return binding.root
    }
    fun setRecyclerViewOfTab(){
      binding.apply {
          val layoutManager = GridLayoutManager(requireContext(), 4)
          categoryRecyclerview.layoutManager = layoutManager
          val adapter = CategoryAdapter(itemCategory) { name ->
          }
          categoryRecyclerview.adapter = adapter
      }
    }


}