package com.nesta.makeitstop

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.nesta.makeitstop.core.database.AppContainer
import com.nesta.makeitstop.core.database.AppDataContainer

class MakeItStopApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}

typealias BottomBarContent = @Composable () -> Unit

class BottomBarState {
    var content by mutableStateOf<BottomBarContent?>(null)
}

val LocalBottomBarState = staticCompositionLocalOf<BottomBarState> {
    error("BottomBarState not provided")
}