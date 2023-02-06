package com.robialpha.android.ui.view.splash

import com.robialpha.android.base.BasePresenter
import javax.inject.Inject

class SplashPresenter @Inject constructor(view: SplashContract.View) :
    BasePresenter<SplashContract.View>(view),
    SplashContract.Presenter {

    override fun getAppVersion() {



    }
}
