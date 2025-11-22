package com.nesta.makeitstop.features.feature_breathing

import android.net.Uri
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nesta.makeitstop.features.feature_breathing.data.viewmodel.BreathingViewModel
import com.nesta.makeitstop.features.feature_breathing.ui.BreathingDashboardScreen
import com.nesta.makeitstop.features.feature_breathing.ui.BreathingTimerCreationScreen
import com.nesta.makeitstop.features.feature_breathing.ui.ComponentBreathing
import com.nesta.makeitstop.navigation.Routes
import com.nesta.makeitstop.ui.AppViewModelProvider
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
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

            val viewModel: BreathingViewModel =
                viewModel(parentEntry, factory = AppViewModelProvider.Factory)

            BreathingDashboardScreen(
                onModuleClick = {
                    val breathingJson = Uri.encode(Json.encodeToString(it))
                    navController.navigate("urgency_breathing/$breathingJson")
                },
                onNavigationClick = {
                    navController.navigate(Routes.Breathing.Add)
                }
            )
        }

        composable(Routes.Breathing.Add) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Routes.Breathing.Graph)
            }

            val coroutineScope = rememberCoroutineScope()

            val viewModel: BreathingViewModel =
                viewModel(viewModelStoreOwner = parentEntry, factory = AppViewModelProvider.Factory)

            BreathingTimerCreationScreen(
                breathingUiState = viewModel.uiState.collectAsState(),
                onAddBreathing = viewModel::updateBreathingUiState,
                addBreathingClick = {
                    coroutineScope.launch {
                        val breathing = viewModel.saveBreathingTimerWithReturn()
                        val breathingJson = Uri.encode(Json.encodeToString(breathing))
                        navController.navigate("urgency_breathing/$breathingJson")

                    }
                }
            )
        }
    }
}