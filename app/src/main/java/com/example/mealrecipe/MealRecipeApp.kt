package com.example.mealrecipe

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyRecipeApp(nav: NavHostController) {
    val recipeViewModel: RecipeViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = nav, startDestination = Screen.RecipeScreen.route) {
        composable(Screen.RecipeScreen.route) {
            MainRecipeScreen(viewState = viewState) {
                nav.currentBackStackEntry?.savedStateHandle?.set(Keys.CategoryKey.key, it)
                nav.navigate(Screen.DetailScreen.route)
            }
        }
        composable(Screen.DetailScreen.route) {
            val cat = nav.previousBackStackEntry?.savedStateHandle?.get<Category>(Keys.CategoryKey.key)
                ?: Category("", "", "", "")
            DetailRecipeScreen(category = cat)
        }
    }
}