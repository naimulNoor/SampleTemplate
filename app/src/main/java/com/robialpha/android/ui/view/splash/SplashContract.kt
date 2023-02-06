package com.robialpha.android.ui.view.splash

import com.robialpha.android.base.BaseContract

interface SplashContract {
    interface View : BaseContract.View {

        fun navigateToLogin()
    }

    interface Presenter : BaseContract.Presenter {
        fun getAppVersion()
    }
}