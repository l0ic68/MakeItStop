package com.nesta.makeitstop.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.nesta.makeitstop.DashboardScreen
import com.nesta.makeitstop.MakeItStopApp
import com.nesta.makeitstop.features.feature_addiction.addictionGraph
import com.nesta.makeitstop.features.feature_sleeping_journal.sleepingJournalGraph

enum class Module {
    Addiction,
    Sleep,
    Breathing
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
            MakeItStopApp(
                onModuleClick = { module ->
                    when (module) {
                        Module.Addiction -> navController.navigate(Routes.Addiction.DashBoard)
                        Module.Sleep -> navController.navigate(Routes.SleepingJournaling.DashBoard)
                        Module.Breathing -> TODO()
                    }
                }
            )
        }

        addictionGraph(navController)
        sleepingJournalGraph(navController)
    }
}