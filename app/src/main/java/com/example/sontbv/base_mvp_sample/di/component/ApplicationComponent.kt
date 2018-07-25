package com.example.sontbv.base_mvp_sample.di.component

import com.example.sontbv.base_mvp_sample.BaseApp
import com.example.sontbv.base_mvp_sample.di.module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}