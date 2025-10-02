package com.nesta.makeitstop.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.R
import com.nesta.makeitstop.features.feature_sleeping_journal.Tab
import com.nesta.makeitstop.ui.theme.materialSymbols
import com.nesta.makeitstop.ui.theme.nunitoFont


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBarNavigation(
    isMainDashBoard: Boolean = true,
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        title =
            {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.Transparent)
                ) {
                    if (isMainDashBoard)
                        Text(
                            text = "menu",
                            fontFamily = materialSymbols,
                            color = Color.White,
                            fontSize = 30.sp,
                            modifier = Modifier.clickable(
                                role = Role.Button,
                                onClick = onClick
                            )
                        )
                    else
                        Text(
                            text = "arrow_left_alt",
                            fontFamily = materialSymbols,
                            color = Color.White,
                            fontSize = 30.sp,
                            modifier = Modifier.clickable(
                                role = Role.Button,
                                onClick = onClick
                            )
                        )
                    Text(
                        text = stringResource(R.string.app_name),
                        color = Color.White,
                        fontSize = 30.sp
                    )
                    Text(
                        text = "settings",
                        fontFamily = materialSymbols,
                        color = Color.White,
                        fontSize = 30.sp
                    )
                }
            }
    )
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopBarNavigation(
        isMainDashBoard = false,
        onClick = {}
    )
}
@Preview
@Composable
fun TopAppBarDashboardPreview() {
    TopBarNavigation(
        onClick = {}
    )
}