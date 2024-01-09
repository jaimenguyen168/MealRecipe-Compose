package com.example.mealrecipe

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailRecipeScreen(
    category: Category
) {
    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            DetailInPortrait(category = category)
        }
        else -> {
            DetailInLandScape(category = category)
        }
    }
}

@Composable
fun DetailInPortrait(
    category: Category
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = category.strCategory,
            textAlign = TextAlign.Center
        )
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "${category.strCategory} thumbnail",
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f)
        )

        Text(
            text = category.strCategoryDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState())
        )
    }
}

@Composable
fun DetailInLandScape(category: Category) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = category.strCategory,
                textAlign = TextAlign.Center
            )
            Image(
                painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = "${category.strCategory} thumbnail",
                modifier = Modifier
                    .wrapContentSize()
                    .aspectRatio(1f)
            )
        }
        Text(
            text = category.strCategoryDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState()).fillMaxHeight()
        )
    }
}
