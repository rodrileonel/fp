package com.appstuddio.cleanmvvm

import android.app.Application
import com.appstuddio.cleanmvvm.core.di.ApplicationComponent
import com.appstuddio.cleanmvvm.core.di.ApplicationModule
import com.appstuddio.cleanmvvm.core.di.DaggerApplicationComponent

import com.appstuddio.cleanmvvm.core.functional.Prefs

class AndroidApplication : Application() {

    lateinit var prefs: Prefs

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
        prefs = Prefs(applicationContext)
    }

    private fun injectMembers() = appComponent.inject(this)

}