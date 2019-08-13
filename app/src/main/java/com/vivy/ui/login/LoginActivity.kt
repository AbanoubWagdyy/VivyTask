package com.vivy.ui.login

import android.content.Intent
import javax.inject.Inject
import android.os.Bundle
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.vivy.R
import com.vivy.data.network.ServiceApi
import com.vivy.di.ViewModelInjectionField
import com.vivy.di.qualifiers.ViewModelInjection
import com.vivy.di.base.BaseActivity
import com.vivy.ui.search.SearchActivity
import com.vivy.utils.*

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
            KeyboardUtils.hideKeyboard(this@LoginActivity)
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
            startSearchScreen()
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
                        getString(R.string.invalid_credentials), 1000
                    ).show()
                }

                else -> {
                    Snackbar.make(
                        findViewById(android.R.id.content),
                        getString(R.string.connection_error), 1000
                    ).show()
                }
            }
        })
    }

    private fun startSearchScreen() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
        finish()
    }
}