package com.com.starter_project.di.modules

import com.com.starter_project.ui.main.MainActivity
import com.com.starter_project.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorsModule {
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivityInjector(): MainActivity
}