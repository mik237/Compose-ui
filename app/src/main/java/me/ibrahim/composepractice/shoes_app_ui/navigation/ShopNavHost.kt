package me.ibrahim.composepractice.shoes_app_ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import me.ibrahim.composepractice.shoes_app_ui.screens.ProductDetailScreen
import me.ibrahim.composepractice.shoes_app_ui.screens.ProductsScreen

@Composable
fun ShopNavHost() {

    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = NavigationItems.PRODUCTS
    ) {
        composable(NavigationItems.PRODUCTS) {
            ProductsScreen(navController)
        }
        composable(
            NavigationItems.PRODUCT_DETAIL + "/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) {
            ProductDetailScreen(it.arguments?.getString("productId") ?: "1")
        }
    }
}