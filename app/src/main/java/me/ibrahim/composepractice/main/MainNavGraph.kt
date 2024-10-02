package me.ibrahim.composepractice.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.ibrahim.composepractice.list_detail_pane.ListDetailLayout

@Composable
fun MainNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.RoutesList,
        modifier = modifier
    ) {
        composable(route = Routes.RoutesList) {
            MainRoutesList(navController)
        }

        composable(route = Routes.ListDetailRoute) {
            ListDetailLayout()
        }
    }
}