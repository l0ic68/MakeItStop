package com.nesta.makeitstop

import android.app.Application
import com.nesta.makeitstop.addiction.data.AppContainer
import com.nesta.makeitstop.addiction.data.AppDataContainer

class MakeItStopApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}