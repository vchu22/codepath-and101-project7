package com.example.recipescroll

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.json.JSONObject

class RecipeAdapter(recipeList: MutableList<JSONObject>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {
    private val recipeList: List<JSONObject> = recipeList

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recipeImage: ImageView
        var textDish : TextView
        val textInstructions : TextView

        init {
            // Find our RecyclerView item's ImageView for future use
            recipeImage = view.findViewById(R.id.recipe_image)
            textDish = view.findViewById(R.id.text_dish)
            textInstructions = view.findViewById(R.id.text_instructions)
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
            .load(recipeList[position].getString("strMealThumb"))
            .centerCrop()
            .into(holder.recipeImage)
        holder.textDish.text = recipeList[position].getString("strMeal")
        holder.textInstructions.text = recipeList[position].getString("strInstructions")
    }

}