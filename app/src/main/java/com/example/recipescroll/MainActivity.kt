package com.example.recipescroll

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var recipeList : MutableList<JSONObject>
    private lateinit var rvRecipes : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rvRecipes = findViewById(R.id.recipe_list)
        recipeList = mutableListOf()
        webQuery("fish")
    }

    private fun webQuery(keyword : String) {
        val client = AsyncHttpClient()

        client["https://www.themealdb.com/api/json/v1/1/search.php?s=$keyword", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Recipe Success", "$json")
                val recipeImageArray = json.jsonObject.getJSONArray("meals")
                for (i in 0 until recipeImageArray.length()) {
                    val obj = recipeImageArray.getJSONObject(i)
                    recipeList.add(obj)
                }
                val adapter = RecipeAdapter(recipeList)
                rvRecipes.adapter = adapter
                rvRecipes.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Recipe Error", errorResponse)
            }
        }]
    }
}