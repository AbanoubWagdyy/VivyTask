package com.vivy.ui.login

import android.content.Context
import dagger.Module
import dagger.Provides
import com.vivy.di.qualifiers.ViewModelInjection
import com.vivy.di.InjectionViewModelProvider

@Module
class LoginModule {
    @Provides
    @ViewModelInjection
    fun provideLoginViewModel(
        activity: LoginActivity,
        viewModelProvider: InjectionViewModelProvider<LoginViewModel>
    ): LoginViewModel = viewModelProvider.get(activity, LoginViewModel::class)
}