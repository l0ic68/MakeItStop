package com.nesta.makeitstop.features.feature_urgency

import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nesta.makeitstop.features.feature_urgency.ui.BreathingScreen
import com.nesta.makeitstop.features.feature_urgency.ui.UrgencyPlanScreen
import com.nesta.makeitstop.navigation.Routes


enum class Module {
    Urgency,
    Breathing,
    FiveSenses,
    Discharge,
    StopMental,
    CorporalReset,

}


fun NavGraphBuilder.urgencyGraph(navController : NavHostController) {
    navigation(
        route = Routes.Urgency.Graph,
        startDestination = Routes.Urgency.Urgency
    ) {

        composable(Routes.Urgency.Urgency) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Urgency.Graph)
            }

            UrgencyPlanScreen(
                onModuleClick = { module ->
                    when (module) {
                        Module.Urgency -> navController.navigate(Routes.Urgency.Urgency)
                        Module.Breathing -> navController.navigate(Routes.Urgency.Breathing)
                        Module.FiveSenses -> navController.navigate(Routes.Urgency.FiveSenses)
                        Module.Discharge -> navController.navigate(Routes.Urgency.Discharge)
                        Module.StopMental -> navController.navigate(Routes.Urgency.StopMental)
                        Module.CorporalReset -> navController.navigate(Routes.Urgency.CorporalReset)
                    }
                }
            )

        }

        composable(Routes.Urgency.Breathing) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Urgency.Graph)
            }

            BreathingScreen()
        }

        composable(Routes.Urgency.FiveSenses) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Urgency.Graph)
            }

        }

        composable(Routes.Urgency.Discharge) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Urgency.Graph)
            }

        }

        composable(Routes.Urgency.StopMental) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Urgency.Graph)
            }

        }

        composable(Routes.Urgency.CorporalReset) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Urgency.Graph)
            }

        }

    }
}