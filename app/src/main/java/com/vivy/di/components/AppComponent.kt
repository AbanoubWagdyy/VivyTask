package com.vivy.di.components

import android.app.Application
import android.content.Context
import com.vivy.App
import com.vivy.di.modules.ActivityInjectorsModule
import com.vivy.di.modules.FragmentInjectorsModule
import com.vivy.di.modules.AppModule
import com.vivy.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityInjectorsModule::class,
        FragmentInjectorsModule::class,
        NetworkModule::class,
        AppModule::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun network(networkModule : NetworkModule): Builder
        fun build(): AppComponent
    }
}