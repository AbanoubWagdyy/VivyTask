package com.vivy.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.vivy.data.network.ServiceApi
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel() : ViewModel() {

    fun setService(serviceApi: ServiceApi) {
        this.serviceApi = serviceApi
    }

    var disposable: Disposable? = null
    lateinit var serviceApi: ServiceApi
}