package com.example.recipescroll

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {
    private val recipeList: List<String> = TODO()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recipeImage: ImageView

        init {
            // Find our RecyclerView item's ImageView for future use
            recipeImage = view.findViewById(R.id.recipe_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = recipeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Get element from your dataset at this position and replace the contents of the view with that element")
    }

}