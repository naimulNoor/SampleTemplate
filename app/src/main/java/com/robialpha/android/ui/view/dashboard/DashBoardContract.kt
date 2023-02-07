package com.robialpha.android.ui.view.dashboard

import com.robialpha.android.base.BaseContract

interface DashBoardContract {

    interface View : BaseContract.View {

        fun navigateToLogin()
    }

    interface Presenter : BaseContract.Presenter {

    }
}