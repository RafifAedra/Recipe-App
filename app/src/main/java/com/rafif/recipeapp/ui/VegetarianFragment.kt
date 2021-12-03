package com.rafif.recipeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.rafif.recipeapp.R
import com.rafif.recipeapp.adapter.RecipeAdapter
import com.rafif.recipeapp.data.DataRecipe
import com.rafif.recipeapp.databinding.FragmentBreakfastBinding
import com.rafif.recipeapp.databinding.FragmentVegetarianBinding


class VegetarianFragment : Fragment() {

    private var _binding: FragmentVegetarianBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVegetarianBinding.inflate(inflater, container, false)

        binding.rvVegetarian.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = RecipeAdapter(DataRecipe.listVegetarian)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}