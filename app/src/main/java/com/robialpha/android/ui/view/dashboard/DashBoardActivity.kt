package com.robialpha.android.ui.view.dashboard

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.bumptech.glide.Glide
import com.robialpha.android.R
import com.robialpha.android.base.MvpBaseActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*


class DashBoardActivity  : MvpBaseActivity<DashBoardPresenter>(), DashBoardContract.View {
    val handler = Handler()
    override fun getContentView(): Int {
        /*  if (mPrefManager.getBoolean(PrefKeys.LOGGED_IN, false)) {
              Navigator.sharedInstance.navigate(getContext(), HomeActivity::class.java)
              finish()
          }*/




        return R.layout.activity_dash_board
    }

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {




//        handler.postDelayed(Runnable {
//            mPresenter.getAppVersion()
//        }, 1000)





        var info= Build.MANUFACTURER +"-"+ Build.MODEL
        var androidversion= Build.VERSION.RELEASE
        Log.d("roni",androidversion)



    }





    override fun onResume() {
        super.onResume()
        handler.postDelayed(Runnable {

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
