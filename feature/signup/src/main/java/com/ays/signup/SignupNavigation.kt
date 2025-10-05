package com.ays.signup

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ays.common.navigation.Graph.HOME_GRAPH
import com.ays.common.navigation.Graph.SIGNUP_GRAPH
import com.ays.common.navigation.SignupRoute.SIGNUP_ROUTE

fun NavGraphBuilder.signupGraph(navController: NavController) {
    navigation(startDestination = SIGNUP_ROUTE, route = SIGNUP_GRAPH) {
        composable(SIGNUP_ROUTE) {
            SignupScreen(
                onSignupSuccess = { navController.navigate(HOME_GRAPH) }
            )
        }
    }
}
