package com.nesta.makeitstop.features.feature_breathing

import android.net.Uri
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nesta.makeitstop.features.feature_breathing.ui.BreathingDashboardScreen
import com.nesta.makeitstop.features.feature_urgency.ui.BreathingScreen
import com.nesta.makeitstop.navigation.Routes
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

fun NavGraphBuilder.breathingGraph(navController: NavHostController) {
    navigation(
        route = Routes.Breathing.Graph,
        startDestination = Routes.Breathing.DashBoard
    ) {
        composable(Routes.Breathing.DashBoard) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Breathing.Graph)
            }

            BreathingDashboardScreen(
                onModuleClick = {
                    val breathingJson = Uri.encode(Json.encodeToString(it))
                    navController.navigate("urgency_breathing/$breathingJson")
                }
            )
        }
    }
}