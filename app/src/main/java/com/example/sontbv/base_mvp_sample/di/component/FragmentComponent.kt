package com.example.sontbv.base_mvp_sample.di.component

import com.example.sontbv.base_mvp_sample.di.module.FragmentModule
import com.example.sontbv.base_mvp_sample.ui.list.ListFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

//    fun inject(aboutFragment: AboutFragment)

    fun inject(listFragment: ListFragment)
}