package com.example.sontbv.base_mvp_sample.di.module

import android.app.Application
import com.example.sontbv.base_mvp_sample.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return baseApp
    }
}