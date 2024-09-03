package me.ibrahim.composepractice.shoes_app_ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import me.ibrahim.composepractice.shoes_app_ui.components.ProductItem
import me.ibrahim.composepractice.shoes_app_ui.navigation.NavigationItems
import me.ibrahim.composepractice.shoes_app_ui.viewmodel.ProductsViewModel

@Composable
fun ProductsScreen(navController: NavController) {
    Scaffold {
        ShoesList(modifier = Modifier.padding(it), navController)
    }
}

@Composable
fun ShoesList(modifier: Modifier, navController: NavController) {

    val productsViewModel: ProductsViewModel = viewModel()

    val products = remember {
        productsViewModel.getProductsList()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(products) { product ->
            ProductItem(product = product) {
                navController.navigate(NavigationItems.PRODUCT_DETAIL + "/${product.id}")
            }
        }
    }

}




