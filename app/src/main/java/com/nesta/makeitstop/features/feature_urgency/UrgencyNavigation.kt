package com.nesta.makeitstop.features.feature_urgency

import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nesta.makeitstop.features.feature_urgency.ui.BreathingScreen
import com.nesta.makeitstop.navigation.Routes

fun NavGraphBuilder.urgencyGraph(navController : NavHostController) {
    navigation(
        route = Routes.Urgency.Graph,
        startDestination = Routes.Urgency.Breathing
    ) {
        composable(Routes.Urgency.Breathing) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Urgency.Graph)
            }

            BreathingScreen(
            )
        }
    }
}