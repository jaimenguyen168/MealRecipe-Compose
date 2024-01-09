package com.example.mealrecipe

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

val recipeService: ApiService by lazy {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    retrofit.create(ApiService::class.java)
}

interface ApiService {
    @GET("categories.php") //end-point
    suspend fun getCategories() : CategoriesResponse
}