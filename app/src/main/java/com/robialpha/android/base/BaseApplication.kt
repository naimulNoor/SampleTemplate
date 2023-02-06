package com.robialpha.android.base

import android.app.Activity
import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.robialpha.android.data.prefs.PrefKeys
import com.robialpha.android.data.prefs.PreferenceManager
import com.robialpha.android.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class BaseApplication : Application(), HasActivityInjector, LifecycleObserver {

    @Inject
    lateinit var mActivityInjector: DispatchingAndroidInjector<Activity>

    private val TAG = BaseApplication::class.java.simpleName

    @Inject
    lateinit var mPrefManager: PreferenceManager

    override fun onCreate() {
        super.onCreate()
        initDagger()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    private fun initDagger() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
       mPrefManager.putBoolean(PrefKeys.LOGGED_IN, false)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return mActivityInjector
    }

}