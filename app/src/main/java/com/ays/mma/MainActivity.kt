package com.ays.mma

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ays.common.navigation.Graph.SIGNUP_GRAPH
import com.ays.home.homeGraph
import com.ays.profile.profileGraph
import com.ays.signup.signupGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val intent = intent
            MMANavHost(intent)
        }
    }
}

@Composable
fun MMANavHost(intent: Intent?) {
    val data = intent?.data
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SIGNUP_GRAPH
    ) {
        signupGraph(navController)
        homeGraph(navController)
        profileGraph(navController)
    }

    if (data != null) {
        navController.handleDeepLink(intent)
    }
}