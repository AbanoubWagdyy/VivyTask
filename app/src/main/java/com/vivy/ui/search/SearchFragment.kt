package com.vivy.ui.search

import android.os.Bundle
import com.vivy.R
import javax.inject.Inject
import com.vivy.di.qualifiers.ViewModelInjection
import com.vivy.di.ViewModelInjectionField
import com.vivy.di.base.BaseFragment

class SearchFragment : BaseFragment() {

    override fun layoutRes() = R.layout.fragment_search

    companion object {
        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }

    @Inject
    @ViewModelInjection
    lateinit var viewModel: ViewModelInjectionField<SearchViewModel>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}