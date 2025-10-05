package com.ays.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.NavController
import androidx.navigation.navDeepLink
import com.ays.common.navigation.Graph.PROFILE_GRAPH
import com.ays.common.navigation.ProfileRoute.EDIT_PROFILE_ROUTE
import com.ays.common.navigation.ProfileRoute.PROFILE_HOME_ROUTE

fun NavGraphBuilder.profileGraph(navController: NavController) {
    navigation(startDestination = PROFILE_HOME_ROUTE, route = PROFILE_GRAPH) {

        composable(PROFILE_HOME_ROUTE) {
            ProfileHomeScreen(
                onEditProfile = { userId ->
                    navController.navigate(EDIT_PROFILE_ROUTE.replace("{userId}", userId))
                }
            )
        }

        composable(
            route = EDIT_PROFILE_ROUTE,
            deepLinks = listOf(
                navDeepLink { uriPattern = "mma://$EDIT_PROFILE_ROUTE" }
            )
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            EditProfileScreen(userId)
        }
    }
}
