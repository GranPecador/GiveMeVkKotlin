package com.example.givemevkkotlin.presenters

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.givemevkkotlin.R
import com.example.givemevkkotlin.views.LoginView

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {
    fun login(isSuccess:Boolean) {
        viewState.startLoading()
        Handler().postDelayed({
            viewState.endLoading()
            if (isSuccess) {
                viewState.openFriends()
            } else {
                viewState.showError( R.string.login_error_credentials)
            }
        },  500)
    }
}