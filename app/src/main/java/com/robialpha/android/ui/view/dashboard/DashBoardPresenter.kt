package com.robialpha.android.ui.view.dashboard

import com.robialpha.android.base.BasePresenter
import javax.inject.Inject

class DashBoardPresenter  @Inject constructor(view: DashBoardContract.View) :

    BasePresenter<DashBoardContract.View>(view),
    DashBoardContract.Presenter
    {


    }
