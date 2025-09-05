package com.nesta.makeitstop

import android.app.Application
import com.nesta.makeitstop.core.database.AppContainer
import com.nesta.makeitstop.core.database.AppDataContainer

class MakeItStopApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}