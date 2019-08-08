package com.com.starter_project.ui.main

import dagger.Module
import dagger.Provides
import com.com.starter_project.di.qualifiers.ViewModelInjection
import com.com.starter_project.di.InjectionViewModelProvider

@Module
class MainModule {

    @Provides
    @ViewModelInjection
    fun provideMainVM(
        activity: MainActivity,
        viewModelProvider: InjectionViewModelProvider<MainViewModel>
    ) = viewModelProvider.get(activity, MainViewModel::class)
}