package com.robialpha.android.ui.view.splash

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.Log
import com.bumptech.glide.Glide
import com.robialpha.android.R
import com.robialpha.android.base.MvpBaseActivity
import com.robialpha.android.data.prefs.Keys
import com.robialpha.android.data.prefs.PrefKeys
import com.robialpha.android.ui.view.dashboard.DashBoardActivity
import com.robialpha.android.utils.AppUtils
import com.robialpha.android.utils.Navigator
import kotlinx.android.synthetic.main.activity_splash_screen.*



class SplashScreenActivity : MvpBaseActivity<SplashPresenter>(), SplashContract.View {
    val handler = Handler()
    override fun getContentView(): Int {
        /*  if (mPrefManager.getBoolean(PrefKeys.LOGGED_IN, false)) {
              Navigator.sharedInstance.navigate(getContext(), HomeActivity::class.java)
              finish()
          }*/




        return R.layout.activity_splash_screen
    }

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {

        Glide.with(this).asGif().load(R.drawable.abc_vector_test).into(iv_robi);
        Navigator.sharedInstance.navigate(this, DashBoardActivity::class.java)


//        handler.postDelayed(Runnable {
//            mPresenter.getAppVersion()
//        }, 1000)





        var info= Build.MANUFACTURER +"-"+Build.MODEL
        var androidversion=Build.VERSION.RELEASE
        Log.d("roni",androidversion)



    }





    override fun onResume() {
        super.onResume()
        handler.postDelayed(Runnable {
            mPresenter.getAppVersion()
        }, 1000)
    }





    override fun navigateToLogin() {

//        if (mPrefManager.getBoolean(PrefKeys.IS_REGISTERED, false) && PreferenceManager(getContext()).getBoolean(Keys.KEEP_ME_LOGGED_IN.name, false) ) {
//            Navigator.sharedInstance.navigate(this, HomeActivity::class.java)
//        } else {
//            Navigator.sharedInstance.navigate(this, LoginActivity::class.java)
//        }






//        if (mPrefManager.getBoolean(PrefKeys.LOGGED_IN, false)) {
//            Navigator.sharedInstance.navigate(this, HomeActivity::class.java)
//        } else {
//            Navigator.sharedInstance.navigate(this, LoginActivity::class.java)
//        }


        finish()

    }

    override fun onNetworkCallStarted(loadingMessage: String) {
        TODO("Not yet implemented")
    }

    override fun onServerError() {
        TODO("Not yet implemented")
    }

    override fun onTimeOutError() {
        TODO("Not yet implemented")
    }

    override fun onNetworkUnavailable() {
        TODO("Not yet implemented")
    }

    override fun onSystemUpgrading() {
        TODO("Not yet implemented")
    }

    override fun onUserDidTooManyAttempts(errorMsg: String) {
        TODO("Not yet implemented")
    }







    }

