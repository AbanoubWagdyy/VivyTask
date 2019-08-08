package com.com.starter_project.ui.main

import com.com.starter_project.R
import javax.inject.Inject
import android.os.Bundle
import com.com.starter_project.di.qualifiers.ViewModelInjection
import com.com.starter_project.di.ViewModelInjectionField
import com.com.starter_project.ui.BaseActivity

class MainActivity : BaseActivity() {

    @Inject
    @ViewModelInjection
    lateinit var viewModel: ViewModelInjectionField<MainViewModel>

    override fun layoutRes() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}