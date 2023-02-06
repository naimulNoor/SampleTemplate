package com.robialpha.android.base

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bumptech.glide.Glide
import com.robialpha.android.R

abstract class BaseDialogFragment constructor(private var gravity: Int = Gravity.TOP) :
    DialogFragment() {

    private var viewUnbinder: Unbinder? = null
    lateinit var rootView: View
    // Dialog >>>>
    var loader: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = getDialogView(inflater, container, savedInstanceState)
        viewUnbinder = ButterKnife.bind(this, rootView)
        return rootView
    }

    protected abstract fun getDialogView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setGravity(gravity)
        isCancelable = false
        onDialogViewReady(arguments)
    }

    protected abstract fun onDialogViewReady(getArguments: Bundle?)

    override fun onDestroyView() {
        super.onDestroyView()
        if (viewUnbinder != null) {
            viewUnbinder?.unbind()
            viewUnbinder = null
        }
    }

    public fun hideProgressDialog() {
        loader?.cancel()
    }


}