package me.ibrahim.composepractice.shoes_app_ui.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Product(
    val id: Int,
    val name: String,
    val color: Color,
    val price: Float,
    val discountedPrice: Float,
    @DrawableRes val image: Int,
    val size: Int = 9,
    val rating: Float
)
