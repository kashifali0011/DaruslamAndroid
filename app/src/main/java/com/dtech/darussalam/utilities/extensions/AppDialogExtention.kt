package com.dtech.darussalam.utilities.extensions

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.text.TextUtils
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.Window
import android.webkit.WebView
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.dtech.darussalam.R
import com.dtech.darussalam.utilities.Constants
import com.dtech.darussalam.utilities.helper.TypeFaceButton
import com.dtech.darussalam.utilities.helper.TypeFaceEditText
import com.dtech.darussalam.utilities.helper.TypeFaceRecyclerView
import com.dtech.darussalam.utilities.helper.TypeFaceTextView
import com.dtech.darussalam.utilities.utils.DateUtil
import com.dtech.darussalam.view.base.ActivityBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


/**
 * Develop By Messagemuse
 */
var loadingDialoge: Dialog? = null
var updateDialoge : Dialog? = null
fun Context.showAppLoader() {
    if (loadingDialoge != null) {
        if (!loadingDialoge!!.isShowing) {
            loadingDialoge = Dialog(this, R.style.Theme_Dialog_Loader)
            loadingDialoge!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            loadingDialoge!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            loadingDialoge!!.setContentView(R.layout.dialoge_app_loader)
            loadingDialoge!!.setCancelable(false)
            loadingDialoge!!.show()
        }
    } else {
        loadingDialoge = Dialog(this, R.style.Theme_Dialog_Loader)
        loadingDialoge!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loadingDialoge!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        loadingDialoge!!.setContentView(R.layout.dialoge_app_loader)
        loadingDialoge!!.setCancelable(false)
        loadingDialoge!!.show()
    }
}

fun hideAppLoader() {
    if (loadingDialoge != null && loadingDialoge!!.isShowing) {
        try {
            loadingDialoge!!.dismiss()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }
}



fun Context.showUpdateDialoge(title: String) {
    if (updateDialoge != null){
        if (updateDialoge!!.isShowing){
            updateDialoge!!.dismiss()
        }
    }
    updateDialoge = Dialog(this, R.style.Theme_Dialog)
    updateDialoge!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
    updateDialoge!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    updateDialoge!!.setCancelable(false)
    updateDialoge!!.setContentView(R.layout.dialoge_update)
    val btnUpdate =  updateDialoge!!.findViewById<Button>(R.id.btnUpdate)
    val tvTitle =  updateDialoge!!.findViewById<TextView>(R.id.tvTitle)
    tvTitle.text = title
    btnUpdate.setOnClickListener {
        if (updateDialoge != null){
            if (updateDialoge!!.isShowing){
                updateDialoge!!.dismiss()
            }
        }
        val appPackageName = packageName // getPackageName() from Context or Activity object

        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
        } catch (anfe: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
        }
    }

    updateDialoge!!.show()
}

@SuppressLint("ResourceAsColor")
fun Context.orderConfirmDialog(orderNumber: String , mListner: orderConfirmDialogClickListner) {
    val dialog = Dialog(this, R.style.Theme_Dialog)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog!!.window?.setBackgroundDrawableResource(R.drawable.bg_white_corner_dialog)
    dialog.setCancelable(true)
    dialog.setContentView(R.layout.dialog_our_order_confirmed)
    val btnBackToHome = dialog.findViewById<TypeFaceButton>(R.id.btnBackToHome)
    val ivOrderConfirm = dialog.findViewById<ImageView>(R.id.ivOrderConfirm)


    ivOrderConfirm.setOnClickListener {
        dialog.dismiss()
    }

    btnBackToHome.setOnClickListener {
        mListner.OrderConfirm()
    }


    dialog.show()

}

interface orderConfirmDialogClickListner {
    fun OrderConfirm()
}




/*fun Context.deleteAccountDialogBox(mListener: CustomerDeleteAccount) {
    val dialog = Dialog(this, R.style.Theme_Dialog)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog!!.window?.setBackgroundDrawableResource(R.drawable.bg_white_corner_dialog)
    dialog.setCancelable(true)
    dialog.setContentView(R.layout.dialog_delete_account)
    val btnDeleteAccount = dialog.findViewById<TypeFaceButton>(R.id.btnDeleteAccount)
    val btnGoBack = dialog.findViewById<TypeFaceButton>(R.id.btnGoBack)
    val et1 = dialog.findViewById<EditText>(R.id.et1)
    val et2 = dialog.findViewById<EditText>(R.id.et2)
    val et3 = dialog.findViewById<EditText>(R.id.et3)
    val et4 = dialog.findViewById<EditText>(R.id.et4)
    btnDeleteAccount.setOnClickListener {

        if (et1.text.isNotEmpty() && et2.text.isNotEmpty() && et3.text.isNotEmpty() && et4.text.isNotEmpty()) {
            mListener.deleteAccount(et1.text.toString() + et2.text.toString() + et3.text.toString() + et4.text.toString())
            dialog.dismiss()
        } else {
            Toast.makeText(applicationContext, "All field is required", Toast.LENGTH_SHORT).show()
        }
    }
    btnGoBack.setOnClickListener {
        dialog.dismiss()
    }
    et1.addTextChangedListener {
        if (et1.hasFocus()) {
            if (et1.text.toString().length == 1) {
                btnDeleteAccount.background = ContextCompat.getDrawable(
                    ActivityBase.activity,
                    R.drawable.bg_orange_btn_delete_customer_account
                )
                et1.clearFocus()
                et2.requestFocus()
            }
        }
    }
    et2.addTextChangedListener {
        if (et2.hasFocus()) {
            if (et2.text.toString().length == 1) {
                btnDeleteAccount.background = ContextCompat.getDrawable(
                    ActivityBase.activity,
                    R.drawable.bg_orange_btn_delete_customer_account
                )
                et2.clearFocus()
                et3.requestFocus()
            }
        }
    }
    et3.addTextChangedListener {
        if (et3.hasFocus()) {
            if (et3.text.toString().length == 1) {
                btnDeleteAccount.background = ContextCompat.getDrawable(
                    ActivityBase.activity,
                    R.drawable.bg_orange_btn_delete_customer_account
                )
                et3.clearFocus()
                et4.requestFocus()
            }
        }
    }
    et4.addTextChangedListener {
        if (et4.hasFocus()) {
            if (et4.text.toString().length == 1) {
                btnDeleteAccount.background = ContextCompat.getDrawable(
                    ActivityBase.activity,
                    R.drawable.bg_orange_btn_delete_customer_account
                )
                et1.clearFocus()
                et2.clearFocus()
                et3.clearFocus()
            }
        }
    }
    et1.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
        if (hasFocus) {
            et1.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_pin)
            et2.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)
            et3.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)
            et4.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)

        }
    }


    et2.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
        if (hasFocus) {
            et1.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)
            et2.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_pin)
            et3.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)
            et4.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)
        }
    }
    et3.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
        if (hasFocus) {
            et1.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)
            et2.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)
            et3.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_pin)
            et4.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)
        }
    }
    et4.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
        if (hasFocus) {
            et1.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)
            et2.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)
            et3.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_disable)
            et4.background = ContextCompat.getDrawable(ActivityBase.activity, R.drawable.bg_et_pin)
        }
    }
    et1.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            //Perform Code
        }
        false
    })
    et2.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            if (TextUtils.isEmpty(et2.text.toString())) {
                et2.clearFocus()
                et1.requestFocus()
            } else {
                et2.setText("")
            }
        }
        false
    })
    et3.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            if (TextUtils.isEmpty(et3.text.toString())) {
                et3.clearFocus()
                et2.requestFocus()
            } else {
                et3.setText("")
            }
        }
        false
    })
    et4.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            if (TextUtils.isEmpty(et4.text.toString())) {
                et4.clearFocus()
                et3.requestFocus()
            } else {
                et4.setText("")
            }
        }
        false
    })
    dialog.show()
}*/

/*interface CustomerDeleteAccount {
    fun deleteAccount(pin: String)
}*/
/*
fun Context.ratingDialog() {
    val dialog = Dialog(this, R.style.Theme_Dialog)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog!!.window?.setBackgroundDrawableResource(R.drawable.bg_white_corner_dialog)
    dialog.setCancelable(true)
    dialog.setContentView(R.layout.dialog_rating_account)
    var btnSubmit = dialog.findViewById<TypeFaceButton>(R.id.btnSubmit)
    val ratingBar = dialog.findViewById<RatingBar>(R.id.myRatingBar)
    if (ratingBar.hasFocus()) {
        btnSubmit!!.setBackgroundResource(R.drawable.bg_btn_go_back)
    }
    btnSubmit.setOnClickListener {
        dialog.dismiss()
    }
    dialog.show()
}

@SuppressLint("ResourceAsColor")
fun Context.rejectProviderDialog(mListner: rejectDialogClickListner) {
    val dialog = Dialog(this, R.style.Theme_Dialog)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog!!.window?.setBackgroundDrawableResource(R.drawable.bg_white_corner_dialog)
    dialog.setCancelable(true)
    dialog.setContentView(R.layout.dialog_reject_provider)
    val btnCancel = dialog.findViewById<TypeFaceButton>(R.id.btnCancel)
    val btnYes = dialog.findViewById<TypeFaceButton>(R.id.btnYes)
    val btnClose = dialog.findViewById<ImageView>(R.id.ivClose)
    val rvOptions = dialog.findViewById<TypeFaceRecyclerView>(R.id.rvOptions)
    rvOptions.apply {
        layoutManager = LinearLayoutManager(ActivityBase.activity)
        var rejectProviderOptionsAdapter: RejectProviderOptionsAdapter =
            RejectProviderOptionsAdapter(ActivityBase.activity, object :
                RejectProviderOptionsAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                }
            })
        rvOptions.adapter = rejectProviderOptionsAdapter
        rejectProviderOptionsAdapter!!.notifyDataSetChanged()
    }
    btnCancel.setOnClickListener {
        dialog.dismiss()
    }
    btnClose.setOnClickListener {
        dialog.dismiss()
    }
    btnYes.setOnClickListener {
        btnYes.setTextColor(blue_text_color)
        btnYes!!.setBackgroundResource(R.drawable.btn_blue_corner)
        mListner.yesBtn()
        dialog.dismiss()
    }

    dialog.show()

}

interface rejectDialogClickListner {
    fun yesBtn()
}*/




