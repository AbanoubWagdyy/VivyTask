package com.vivy.ui.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.vivy.R
import com.vivy.data.model.Token
import javax.inject.Inject
import com.vivy.ui.BaseViewModel
import com.vivy.utils.BASE_LOGIN_URL
import com.vivy.utils.INVALID_PASSWORD
import com.vivy.utils.INVALID_USERNAME
import com.vivy.utils.UNKNOWN_ERROR
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.HttpException

class LoginViewModel @Inject constructor() : BaseViewModel() {

    var loadingObserver = MutableLiveData<Boolean>()

    var errorObserver = MutableLiveData<Int>()

    var responseObserver = MutableLiveData<Token>()

    fun login(username: String?, password: String?) {
        if (!isCredentialsValid(username, password))
            return

        loadingObserver.value = true

        disposable = serviceApi.login(
            BASE_LOGIN_URL,
            username!!, password!!
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loadingObserver.value = true }
            .doOnTerminate { }
            .subscribe(
                { result ->
                    loadingObserver.value = false
                    if (result != null)
                        responseObserver.value = result
                    else
                        errorObserver.value = UNKNOWN_ERROR
                },
                {
                    val exception = it as HttpException
                    errorObserver.value = exception.code()
                }
            )
    }

    private fun isCredentialsValid(username: String?, password: String?): Boolean {
        if (username == null || username.trim().isEmpty()) {
            errorObserver.value = INVALID_USERNAME
            return false
        }

        if (password == null || password.trim().isEmpty()) {
            errorObserver.value = INVALID_PASSWORD
            return false
        }

        return true
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}