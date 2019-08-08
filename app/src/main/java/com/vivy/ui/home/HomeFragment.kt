package com.com.starter_project.ui.home

import android.os.Bundle
import javax.inject.Inject
import com.com.starter_project.R
import com.com.starter_project.di.qualifiers.ViewModelInjection
import com.com.starter_project.di.ViewModelInjectionField
import com.com.starter_project.ui.BaseFragment

class HomeFragment : BaseFragment() {

    override fun layoutRes() = R.layout.fragment_home

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    @Inject
    @ViewModelInjection
    lateinit var viewModel: ViewModelInjectionField<HomeViewModel>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}