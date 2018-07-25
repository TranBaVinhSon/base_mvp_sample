package com.example.sontbv.base_mvp_sample

import android.app.Application
import com.example.sontbv.base_mvp_sample.di.component.ApplicationComponent
import com.example.sontbv.base_mvp_sample.di.module.ApplicationModule
import com.example.sontbv.base_mvp_sample.di.component.DaggerApplicationComponent

class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()

        if (BuildConfig.DEBUG) {
            // Maybe TimberPlant etc.
        }
    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}