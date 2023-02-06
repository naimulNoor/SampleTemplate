package com.robialpha.android.base

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem

import com.robialpha.android.data.prefs.Keys
import com.robialpha.android.data.prefs.PreferenceManager
import com.robialpha.android.utils.AppUtils


abstract class BaseActivity : AppCompatActivity() {

    protected val TAG: String  by lazy {
        this.javaClass.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getContentView())
        supportActionBar?.let {
            supportActionBar!!.apply {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
            }
        }

        onViewReady(savedInstanceState, intent)
    }

    abstract fun getContentView(): Int
    abstract fun onViewReady(savedInstanceState: Bundle?, intent: Intent)

    protected fun getContext(): Context {
        return this
    }


    override fun onDestroy() {
        super.onDestroy()

    }


}