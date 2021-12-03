package com.rafif.recipeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.rafif.recipeapp.R
import com.rafif.recipeapp.adapter.RecipeAdapter
import com.rafif.recipeapp.data.Recipe
import com.rafif.recipeapp.databinding.FragmentSeafoodBinding


class SeafoodFragment : Fragment() {

    private var _binding: FragmentSeafoodBinding? = null
    private val binding get() = _binding!!

    private var listRecipe: ArrayList<Recipe> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSeafoodBinding.inflate(inflater, container, false)

        initdata()

        binding.rvSeafood.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = RecipeAdapter(listRecipe)
        }

        return binding.root
    }

    private fun initdata(){
        activity?.resources?.apply {
            val arrName = getStringArray(R.array.name_seafood)
            val arrCategory = getStringArray(R.array.category_seafood)
            val arrDescription = getStringArray(R.array.description_seafood)
            val arrIngredient = getStringArray(R.array.ingredients_seafood)
            val arrInstruction = getStringArray(R.array.instructions_seafood)
            val arrPhoto = getStringArray(R.array.photo_seafood)
            val arrPrice = getStringArray(R.array.price_seafood)
            val arrCalories = getStringArray(R.array.calories_seafood)
            val arrCarbo = getStringArray(R.array.carbo_seafood)
            val arrProtein = getStringArray(R.array.protein_seafood)

            for (data in arrName.indices){
                val recipe = Recipe(
                    name = arrName[data],
                    category = arrCategory[data],
                    description = arrDescription[data],
                    ingredients = arrIngredient[data],
                    instructions = arrInstruction[data],
                    photo = arrPhoto[data],
                    price = arrPrice[data],
                    calories = arrCalories[data],
                    carbo = arrCarbo[data],
                    protein = arrProtein[data]
                )
                listRecipe.add(recipe)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}