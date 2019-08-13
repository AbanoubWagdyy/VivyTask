package com.vivy.ui.login

import android.content.Context
import javax.inject.Inject
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.vivy.R
import com.vivy.data.network.ServiceApi
import com.vivy.di.ViewModelInjectionField
import com.vivy.di.qualifiers.ViewModelInjection
import com.vivy.ui.BaseActivity

import com.vivy.utils.DialogUtils
import com.vivy.utils.INVALID_CREDENTIALS
import com.vivy.utils.INVALID_PASSWORD
import com.vivy.utils.INVALID_USERNAME
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    @Inject
    @ViewModelInjection
    lateinit var viewModelInjector: ViewModelInjectionField<LoginViewModel>

    @Inject
    lateinit var serviceApi: ServiceApi

    override fun layoutRes() = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelInjector.get().setService(serviceApi)

        initObservers()

        initUI()
    }

    private fun initUI() {
        login.setOnClickListener {
            viewModelInjector.get().login(username.text.toString(), password.text.toString())
        }
    }

    private fun initObservers() {

        viewModelInjector.get().loadingObserver.observe(this, Observer { isLoading ->
            if (isLoading)
                DialogUtils.showLoadingDialog(this@LoginActivity)
            else
                DialogUtils.dismissProgressDialog()
        })

        viewModelInjector.get().responseObserver.observe(this, Observer { response ->

        })

        viewModelInjector.get().errorObserver.observe(this, Observer {
            when (it) {
                INVALID_USERNAME -> {
                    username.error = getString(R.string.invalid_username)
                }

                INVALID_PASSWORD -> {
                    password.error = getString(R.string.invalid_password)
                }

                INVALID_CREDENTIALS -> {
                    Snackbar.make(
                        findViewById(android.R.id.content),
                        getString(R.string.invalid_credentials), 3
                    ).show()
                }

                else -> {
                    Snackbar.make(
                        findViewById(android.R.id.content),
                        getString(R.string.connection_error), 3
                    ).show()
                }
            }
        })
    }
}