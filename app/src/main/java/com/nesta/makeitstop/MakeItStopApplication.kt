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
    var content by mutableStateOf<(@Composable () -> Unit)?>(null)
        private set
    private var ownerRef: Any? = null

    fun setWithOwner(owner: Any, content: @Composable () -> Unit) {
        ownerRef = owner
        this.content = content
    }
    fun clearIfSame(owner: Any) {
        if (ownerRef === owner) {
            content = null
            ownerRef = null
        }
    }

    fun clear() {
            content = null
            ownerRef = null

    }
}

val LocalBottomBarState = staticCompositionLocalOf<BottomBarState> {
    error("BottomBarState not provided")
}