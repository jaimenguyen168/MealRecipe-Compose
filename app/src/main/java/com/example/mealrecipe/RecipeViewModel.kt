package com.example.mealrecipe

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class RecipeViewModel : ViewModel() {

    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoriesState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                recipeService.getCategories().let {
                    _categoriesState.value = _categoriesState.value.copy(
                        categoryList = it.categories,
                        loading = false,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching Categories: ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading : Boolean = true,
        val categoryList: List<Category> = emptyList(),
        val error: String? = null
    )
}