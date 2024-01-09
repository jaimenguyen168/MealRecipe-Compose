package com.example.mealrecipe

sealed class Screen(val route: String) {
    data object RecipeScreen: Screen("mainRecipeScreen")
    data object DetailScreen: Screen("detailRecipeScreen")
}

sealed class Keys(val key: String) {
    data object CategoryKey: Keys("cat")
}