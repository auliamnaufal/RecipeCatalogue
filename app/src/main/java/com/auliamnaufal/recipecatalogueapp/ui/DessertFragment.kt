package com.auliamnaufal.recipecatalogueapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.auliamnaufal.recipecatalogueapp.R
import com.auliamnaufal.recipecatalogueapp.adapter.RecipesAdapter
import com.auliamnaufal.recipecatalogueapp.data.DataRecipes
import com.auliamnaufal.recipecatalogueapp.databinding.FragmentDessertBinding

class DessertFragment : Fragment() {
    private var _binding: FragmentDessertBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDessertBinding.inflate(inflater, container, false)

        binding.rvDessert.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = RecipesAdapter(DataRecipes.listDessert)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}