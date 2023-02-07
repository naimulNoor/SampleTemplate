package com.robialpha.android.di.module

import com.robialpha.android.di.scope.ActivityScope
import com.robialpha.android.ui.view.dashboard.DashBoardActivity
import com.robialpha.android.ui.view.dashboard.DashBoardViewModel

import com.robialpha.android.ui.view.splash.SplashScreenActivity
import com.robialpha.android.ui.view.splash.SplashViewModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module(includes = [FragmentBindingModule::class])
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SplashViewModule::class])
    abstract fun bindEventSplashActivity(): SplashScreenActivity


    @ActivityScope
    @ContributesAndroidInjector(modules = [DashBoardViewModel::class])
    abstract fun bindEventDashBoard(): DashBoardActivity
}