package com.nesta.makeitstop.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nesta.makeitstop.navigation.AppNavHost
import com.nesta.makeitstop.navigation.Routes
import kotlinx.coroutines.launch

@Composable
fun PreviewBackground(content: @Composable () -> Unit) {
    Scaffold(
        containerColor = Color.Transparent,
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    0f to Color(0xFF101d3f),
                    0.6f to Color(0xFF2e2b57),
                    1f to Color(0xFF3b3063)
                )
            ),
        topBar = {
            TopBarNavigation(
                false,
                onClick = {
                }
            )
        },
        bottomBar = {

        }
    ) { innerPadding ->
        ModalNavigationDrawer(
            modifier = Modifier
                .padding(innerPadding),
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
            content()
        }
    }
}