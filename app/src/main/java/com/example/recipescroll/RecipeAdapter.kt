package com.example.recipescroll

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecipeAdapter(recipeList: MutableList<String>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {
    private val recipeList: List<String> = recipeList

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
        Glide.with(holder.itemView)
            .load(recipeList[position])
            .centerCrop()
            .into(holder.recipeImage)
    }

}