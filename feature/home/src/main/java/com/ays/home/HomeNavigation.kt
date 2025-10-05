package com.ays.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ays.common.navigation.Graph.HOME_GRAPH
import com.ays.common.navigation.Graph.PROFILE_GRAPH
import com.ays.common.navigation.HomeRoute.HOME_ROUTE

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(startDestination = HOME_ROUTE, route = HOME_GRAPH) {
        composable(HOME_ROUTE) {
            HomeScreen(
                onProfileClick = { navController.navigate(PROFILE_GRAPH) }
            )
        }
    }
}