package com.vivy.di.modules

import com.vivy.ui.search.SearchFragment
import com.vivy.ui.search.SearchModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentInjectorsModule {

    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun homeFragmentInjector(): SearchFragment
}