package com.nesta.makeitstop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.nesta.makeitstop.ui.addiction.CravingScreen
import com.nesta.makeitstop.ui.addiction.FeelingScreen
import com.nesta.makeitstop.ui.addiction.OnBoardingScreen

enum class Screen {
    OnBoardingScreen,
    FeelingScreen,
    CravingScreen
}
@Composable
fun DashboardScreen() {
    var currentScreen by remember { mutableStateOf(Screen.OnBoardingScreen) }

    when (currentScreen) {
        Screen.CravingScreen -> CravingScreen(onClick = { currentScreen = Screen.FeelingScreen })
        Screen.OnBoardingScreen -> OnBoardingScreen(
            "J'ai envie de fumer",
            onClick = { currentScreen = Screen.CravingScreen })
        Screen.FeelingScreen -> FeelingScreen(onClick = { currentScreen = Screen.OnBoardingScreen })
    }

}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}