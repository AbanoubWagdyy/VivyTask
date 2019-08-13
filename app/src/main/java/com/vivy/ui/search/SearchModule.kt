package com.vivy.ui.search

import dagger.Module
import dagger.Provides
import com.vivy.di.qualifiers.ViewModelInjection
import com.vivy.di.InjectionViewModelProvider

@Module
class SearchModule {

    @Provides
    @ViewModelInjection
    fun provideHomeVM(
        fragment: SearchFragment,
        viewModelProvider: InjectionViewModelProvider<SearchViewModel>
    ) = viewModelProvider.get(fragment, SearchViewModel::class)
}