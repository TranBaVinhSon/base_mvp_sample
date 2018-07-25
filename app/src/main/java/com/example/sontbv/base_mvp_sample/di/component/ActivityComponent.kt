package com.example.sontbv.base_mvp_sample.di.component

import com.example.sontbv.base_mvp_sample.di.module.ActivityModule
import com.example.sontbv.base_mvp_sample.ui.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}