package com.com.starter_project.di.modules

import com.com.starter_project.ui.home.HomeFragment
import com.com.starter_project.ui.home.HomeModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentInjectorsModule {

    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun homeFragmentInjector(): HomeFragment
}