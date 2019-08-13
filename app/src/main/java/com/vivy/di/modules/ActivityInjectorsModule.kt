package com.vivy.di.modules

import com.vivy.ui.login.LoginModule
import com.vivy.ui.login.LoginActivity
import com.vivy.ui.search.SearchActivity
import com.vivy.ui.search.SearchModule
import com.vivy.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorsModule {

    @ContributesAndroidInjector
    abstract fun splashActivityInjector(): SplashActivity

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun loginActivityInjector(): LoginActivity

    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun searchActivityInjector(): SearchActivity
}