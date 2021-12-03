package com.rafif.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rafif.recipeapp.data.Recipe
import com.rafif.recipeapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val RECIPE_DATA = "recipes"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataRecipes = intent.getParcelableExtra<Recipe>(RECIPE_DATA) as Recipe

        binding.apply {
            tvNameRecipeDetail.text = dataRecipes.name
            tvCalories.text = dataRecipes.calories
            tvCarbo.text = dataRecipes.carbo
            tvProtein.text = dataRecipes.protein
            tvDescriptionDetail.text = dataRecipes.description
            tvIngredientsDetail.text = dataRecipes.ingredients
            tvInstructionDetail.text = dataRecipes.instructions
        }

        Glide.with(this).load(dataRecipes.photo).into(binding.imgDetail)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}