package com.nesta.makeitstop.features.feature_sleeping_journal.ui

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.features.feature_sleeping_journal.Tab


@Composable
fun BottomSleepingJournalingNavigation(
    onTabSelected: (Tab) -> Unit,
    currentTab: Tab,
    modifier: Modifier
) {
    NavigationBar(
        containerColor = Color.Transparent,
        contentColor = Color.White,
        modifier = modifier.heightIn(max = 56.dp)
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            selected = currentTab == Tab.Sleeping,
            onClick = {
                onTabSelected(Tab.Sleeping)
            },

        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            },
            selected = currentTab == Tab.Dashboard,
            onClick = {
                onTabSelected(Tab.Dashboard)
            }
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBarSleepingJournalingNavigation() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        title =
            {
                Text(
                    text = "Journaling du soir",
                    color = Color.White,
                    fontSize = 30.sp
                )
            }
    )
}