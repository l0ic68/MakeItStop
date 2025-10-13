package com.nesta.makeitstop.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.nesta.makeitstop.MakeItStopApp
import com.nesta.makeitstop.core.ui.SettingsScreen
import com.nesta.makeitstop.features.feature_addiction.addictionGraph
import com.nesta.makeitstop.features.feature_dashboard.ui.DashboardScreen
import com.nesta.makeitstop.features.feature_sleeping_journal.sleepingJournalGraph
import com.nesta.makeitstop.features.feature_urgency.urgencyGraph

enum class Module {
    Addiction,
    Sleep,
    Breathing,
    Urgency
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home,
        modifier = modifier
    ) {
        // Dashboard
        composable(route = Routes.Home) {
            DashboardScreen(
                onModuleClick = { module ->
                    when (module) {
                        Module.Addiction -> navController.navigate(Routes.Addiction.DashBoard)
                        Module.Sleep -> navController.navigate(Routes.SleepingJournaling.Sleeping)
                        Module.Urgency -> navController.navigate(Routes.Urgency.Urgency)
                        else -> navController.navigate(Routes.SleepingJournaling.DashBoard)
                    }
                }
            )
        }
        composable(route = Routes.Settings) {
            SettingsScreen()
        }

        addictionGraph(navController)
        sleepingJournalGraph(navController)
        urgencyGraph(navController)
    }
}