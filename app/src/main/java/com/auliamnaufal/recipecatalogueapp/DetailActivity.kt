package com.auliamnaufal.recipecatalogueapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auliamnaufal.recipecatalogueapp.data.Recipes
import com.auliamnaufal.recipecatalogueapp.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    companion object {
        const val RECIPES_DATA = "recipes"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataRecipes = intent.getParcelableExtra<Recipes>(RECIPES_DATA) as Recipes

        binding.apply {
            tvNameRecipeDetail.text = dataRecipes.name
            tvDescriptionDetail.text = dataRecipes.description
            tvIngredientsDetail.text = dataRecipes.ingredients
            tvInstructionDetail.text = dataRecipes.instructions
            tvCalories.text = dataRecipes.calories
            tvCarbo.text = dataRecipes.carbo
            tvProtein.text = dataRecipes.protein
        }

        Glide.with(this).load(dataRecipes.photo).into(binding.imgDetail)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}