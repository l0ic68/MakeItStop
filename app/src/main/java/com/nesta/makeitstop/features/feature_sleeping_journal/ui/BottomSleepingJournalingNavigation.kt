package com.nesta.makeitstop.features.feature_sleeping_journal.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nesta.makeitstop.features.feature_sleeping_journal.Tab


@Composable
fun BottomSleepingJournalingNavigation(
    onTabSelected: (Tab) -> Unit,
    currentTab: Tab,
    modifier: Modifier
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
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
            }
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