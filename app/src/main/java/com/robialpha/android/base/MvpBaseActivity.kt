package com.robialpha.android.base

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bumptech.glide.Glide
import com.robialpha.android.R
import com.robialpha.android.data.prefs.Keys
import com.robialpha.android.data.prefs.PreferenceManager
import com.robialpha.android.utils.*
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import kotlin.system.exitProcess


abstract class MvpBaseActivity<P : BaseContract.Presenter> : AppCompatActivity(), BaseContract.View,
    HasSupportFragmentInjector {

    protected val TAG: String by lazy {
        this.javaClass.simpleName
    }

    private var progressDialog: ProgressDialog? = null
    private var unBinder: Unbinder? = null

    @Inject
    lateinit var mFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var mPresenter: P



    @Inject
    lateinit var mAppLogger: AppLogger

    @Inject
    lateinit var mPrefManager: PreferenceManager

    var mAppLanguage: String? = null

    // Dialog >>>>
    var loader: AlertDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(getContentView())
        unBinder = ButterKnife.bind(this)
        supportActionBar?.let {
            supportActionBar!!.apply {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
            }
        }
        mPrefManager.putBoolean("running", true)
        onViewReady(savedInstanceState, intent)
    }

    abstract fun getContentView(): Int
    abstract fun onViewReady(savedInstanceState: Bundle?, intent: Intent)




    protected fun hideProgressDialog() {
        loader?.cancel()
    }



    override fun getContext(): Context {
        return this
    }


    override fun onNetworkCallEnded() {
        hideProgressDialog()
    }



    override fun onUserUnauthorized(errorMessage: String) {
        mPrefManager.clearPreference()

    }

    override fun onUserDisabled(errorMsg: String) {

    }


    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return mFragmentInjector
    }


}