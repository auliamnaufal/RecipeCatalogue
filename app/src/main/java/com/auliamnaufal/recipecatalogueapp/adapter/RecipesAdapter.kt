package com.auliamnaufal.recipecatalogueapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auliamnaufal.recipecatalogueapp.DetailActivity
import com.auliamnaufal.recipecatalogueapp.data.Recipes
import com.auliamnaufal.recipecatalogueapp.databinding.RowItemRecipeBinding
import com.bumptech.glide.Glide

class RecipesAdapter(val listRecipes: ArrayList<Recipes>): RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: RowItemRecipeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            with(listRecipes[position]) {
                tvNameRecipe.text = name
                tvCategory.text = category
                tvPrice.text = price
                Glide.with(imgRecipe.context).load(photo).into(imgRecipe)
            }
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.RECIPES_DATA, listRecipes[position])
            it.context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int = listRecipes.size

}