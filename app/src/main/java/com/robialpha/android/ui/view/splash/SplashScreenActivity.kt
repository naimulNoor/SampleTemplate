package com.robialpha.android.ui.view.splash

import android.content.Intent
import android.os.Bundle
import com.robialpha.android.R
import com.robialpha.android.base.MvpBaseActivity
import com.robialpha.android.data.prefs.PrefKeys

import com.robialpha.android.utils.AppUtils

abstract class SplashScreenActivity : MvpBaseActivity<SplashPresenter>(), SplashContract.View {

    override fun getContentView(): Int {

        return R.layout.activity_splash_screen
    }

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {


    }

    override fun navigateToLogin() {
        TODO("Not yet implemented")
    }




}
