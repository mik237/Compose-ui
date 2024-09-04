package me.ibrahim.composepractice.shoes_app_ui.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import me.ibrahim.composepractice.R
import me.ibrahim.composepractice.shoes_app_ui.models.Product


class ProductsViewModel : ViewModel() {

    val products = listOf(
        Product(
            id = 1,
            name = "Shoes Blue",
            color = Color(0xff85c1e9),
            price = 1200f,
            discountedPrice = 1000f,
            rating = 4.7f,
            image = R.drawable.s1,
            size = 8
        ), Product(
            id = 2,
            name = "Shoes Yellow",
            color = Color.Yellow,
            price = 1200f,
            discountedPrice = 1000f,
            rating = 4.7f,
            image = R.drawable.s2,
            size = 9
        ), Product(
            id = 3,
            name = "Shoes Blue",
            color = Color.Cyan,
            price = 1200f,
            discountedPrice = 1000f,
            rating = 4.7f,
            image = R.drawable.s3,
            size = 7
        ), Product(
            id = 4,
            name = "Shoes Yello",
            color = Color.Red,
            price = 1200f,
            discountedPrice = 1000f,
            rating = 4.7f,
            image = R.drawable.s4,
            size = 10
        ), Product(
            id = 5,
            name = "Shoes Yello",
            color = Color(0x50000000),
            price = 1200f,
            discountedPrice = 1000f,
            rating = 4.7f,
            image = R.drawable.s5,
            size = 8
        ), Product(
            id = 6,
            name = "Shoes Yello",
            color = Color(0xfffadbd8),
            price = 1200f,
            discountedPrice = 1000f,
            rating = 4.7f,
            image = R.drawable.s6,
            size = 9
        ), Product(
            id = 7,
            name = "Shoes Yello",
            color = Color(0xff85c1e9),
            price = 1200f,
            discountedPrice = 1000f,
            rating = 4.7f,
            image = R.drawable.s7,
            size = 7
        ), Product(
            id = 8,
            name = "Shoes Yello",
            color = Color(0xffa569bd),
            price = 1200f,
            discountedPrice = 1000f,
            rating = 4.7f,
            image = R.drawable.s8,
            size = 6
        ), Product(
            id = 9,
            name = "Shoes Yello",
            color = Color.LightGray,
            price = 1200f,
            discountedPrice = 1000f,
            rating = 4.7f,
            image = R.drawable.s9,
            size = 8
        ), Product(
            id = 10,
            name = "Shoes Yello",
            color = Color(0xfff1948a),
            price = 1200f,
            discountedPrice = 1000f,
            rating = 4.7f,
            image = R.drawable.s10,
            size = 11
        )
    )

    fun getProduct(id: Int): Product {
        return products.first { it.id == id }
    }

    fun getProductsList(): List<Product> {
        return products
    }
}