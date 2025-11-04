package com.nesta.makeitstop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nesta.makeitstop.core.ui.TopBarNavigation
import com.nesta.makeitstop.features.feature_sleeping_journal.ui.BottomSleepingJournalingNavigation
import com.nesta.makeitstop.navigation.AppNavHost
import com.nesta.makeitstop.navigation.Module
import com.nesta.makeitstop.navigation.Routes
import com.nesta.makeitstop.ui.theme.titleColor
import kotlinx.coroutines.launch


/**
 * enum values that represent the screens in the app
 */
enum class MakeItStopScreen() {
    DashBoard,
    Addiction
}


@Composable
fun MakeItStopApp(
    navController: NavHostController
) {
    val backstackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backstackEntry?.destination?.route
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val bottomBarState = remember { BottomBarState() }
    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, _, _ ->
            bottomBarState.clear() // ou clearIfSame(owner)
        }
    }
    CompositionLocalProvider(LocalBottomBarState provides bottomBarState) {

        Scaffold(
            containerColor = Color.Transparent,
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        0f to Color(0xFF0E1B4A),
                        0.6f to Color(0xFF1B2B6A),
                        1f to Color(0xFF2B2F73)
                    )
                ),
            topBar = {
                TopBarNavigation(
                    currentRoute == "home",
                    onClick = {
                        if (currentRoute != "home")
                            navController.navigate(Routes.Home)
                        else {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }
                    },
                    onClickSettings = {
                        navController.navigate(Routes.Settings)
                    }
                )
            },
            bottomBar = {
                LocalBottomBarState.current.content?.invoke()
            }
        ) { innerPadding ->
            ModalNavigationDrawer(
                modifier = Modifier
                    .padding(innerPadding),
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet {
                        Text("Drawer title", modifier = Modifier.padding(16.dp))
                        HorizontalDivider()
                        NavigationDrawerItem(
                            label = { Text(text = "Drawer Item") },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        // ...other drawer items
                    }
                },
                gesturesEnabled = false
            ) {
                AppNavHost(
                    navController = navController,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}
