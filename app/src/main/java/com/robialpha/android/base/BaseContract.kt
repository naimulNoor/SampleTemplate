package com.robialpha.android.base

import android.content.Context

interface BaseContract {

    interface View {

        fun onNetworkCallStarted(loadingMessage: String)

        fun onNetworkCallEnded()

        fun onServerError()

        fun onTimeOutError()

        fun onNetworkUnavailable()

        fun onUserUnauthorized(errorMessage: String)

        fun onUserDisabled(errorMsg: String)


        fun onSystemUpgrading()

        fun onUserDidTooManyAttempts(errorMsg: String)


        fun getContext(): Context

    }

    interface Presenter {

        fun detachView()

        fun clearDisposable()

    }
}