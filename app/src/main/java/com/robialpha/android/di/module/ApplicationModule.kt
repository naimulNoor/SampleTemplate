package com.robialpha.android.di.module

import android.content.Context
import com.robialpha.android.base.BaseApplication
import com.robialpha.android.data.prefs.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.robialpha.android.rx.AppSchedulerProvider
import com.robialpha.android.utils.*

@Module
class ApplicationModule {

    @Provides
    fun provideContext(baseApp: BaseApplication): Context {
        return baseApp
    }
    @Provides
    @Singleton
    fun providePreferenceManager(context: Context): PreferenceManager {
        return PreferenceManager(context)
    }


    @Provides
    @Singleton
    fun provideAppSchedule(): AppSchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideAppLogger(): AppLogger {
        return AppLogger()
    }


}