package com.robialpha.android.base

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bumptech.glide.Glide
import com.robialpha.android.R
import com.robialpha.android.data.prefs.Keys
import com.robialpha.android.data.prefs.PreferenceManager
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import kotlin.system.exitProcess

abstract class BaseFragment<P : BaseContract.Presenter> : Fragment(), BaseContract.View {

    protected val TAG: String by lazy {
        this.javaClass.simpleName
    }

    private var progressDialog: ProgressDialog? = null
    private var viewUnbinder: Unbinder? = null

    @Inject
    lateinit var mPresenter: P


    @Inject
    lateinit var mPrefManager: PreferenceManager

    lateinit var rootView: View

    var mAppLanguage: String? = null

    // Dialog >>>>
    var loader: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Nullable
    override fun onCreateView(
        @NonNull inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        rootView = getFragmentView(inflater, container, savedInstanceState)
        viewUnbinder = ButterKnife.bind(this, rootView)
        onViewReady(arguments)
        return rootView
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }


    protected abstract fun getFragmentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View

    protected abstract fun onViewReady(getArguments: Bundle?)


    private fun hideProgressDialog() {
        loader?.cancel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        hideProgressDialog()
        mPresenter.clearDisposable()
        mPresenter.detachView()
    }

    override fun onDestroy() {
        viewUnbinder?.let {
            viewUnbinder!!.unbind()
            viewUnbinder = null
        }
        super.onDestroy()
    }


    override fun getContext(): Context {
        return activity!!
    }


    override fun onNetworkCallEnded() {
        if (activity != null)
            hideProgressDialog()
    }


}


