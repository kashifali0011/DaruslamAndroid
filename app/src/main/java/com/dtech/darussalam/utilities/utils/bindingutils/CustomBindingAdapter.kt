package com.dtech.darussalam.utilities.utils.bindingutils

import android.annotation.TargetApi
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.Html
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.dtech.darussalam.DarusslamApp
import com.dtech.darussalam.R
import com.dtech.darussalam.data.model.responsemodel.Transactions

import com.dtech.darussalam.utilities.Constants
import com.dtech.darussalam.utilities.enums.OrderStatus
import com.dtech.darussalam.utilities.enums.TransactionType
import com.dtech.darussalam.utilities.extensions.dpToPx
import com.dtech.darussalam.utilities.extensions.load
import com.dtech.darussalam.utilities.extensions.loadDps
import com.dtech.darussalam.utilities.extensions.loadSvg

import com.dtech.darussalam.utilities.helper.TypeFaceRecyclerView
import com.dtech.darussalam.utilities.helper.TypeFaceTextView
import com.dtech.darussalam.utilities.utils.DateUtil
import com.dtech.darussalam.utilities.utils.DateUtil.getLocalDate
import com.dtech.darussalam.view.base.ActivityBase

/**
 * Develop By Messagemuse
 */
class CustomBindingAdapter {
    companion object {
        @BindingAdapter("app:visibleGone")
        @JvmStatic
        fun showHide(view: View, show: Boolean) {
            view.visibility = if (show) View.VISIBLE else View.GONE
        }

        @BindingAdapter("app:visibleInVisible")
        @JvmStatic
        fun showInvisible(view: View, show: Boolean) {
            view.visibility = if (show) View.VISIBLE else View.INVISIBLE
        }


        @BindingAdapter("app:loadImage")
        @JvmStatic
        fun setImage(view: ImageView, imageUrl: String?) {
            if (imageUrl != null)
                view.load(imageUrl)
        }

        @BindingAdapter("app:loadSvgImage")
        @JvmStatic
        fun setSvgImage(view: ImageView, imageUrl: String?) {
            if (imageUrl != null)
                view.loadSvg(imageUrl)
        }

        @BindingAdapter("app:loadImageDp")
        @JvmStatic
        fun setImageDp(view: ImageView, imageUrl: String?) {
            if (imageUrl != null)
                view.loadDps(imageUrl)
        }


        @BindingAdapter("app:loadSvg")
        @JvmStatic
        fun setSVG(view: ImageView, imageUrl: String?) {
            //if (imageUrl != null)
               // ActivityBase.activity.loadSVG(view, imageUrl)
        }



        @BindingAdapter("app:emptyText")
        @JvmStatic
        fun setEmptyText(view: TypeFaceRecyclerView, data: String) {
            view.setEmptyText(data)
        }

        @BindingAdapter("app:emptyTextColor")
        @JvmStatic
        fun setEmptyTextColor(view: TypeFaceRecyclerView, data: Int) {
            view.setEmptyTextColor(data)
        }

        @BindingAdapter("app:emptyIcon")
        @JvmStatic
        fun setEmptyIcon(view: TypeFaceRecyclerView, data: Drawable) {
            view.setEmptyIcon(data)
        }

        @BindingAdapter("app:emptyIconColor")
        @JvmStatic
        fun setEmptyIconColor(view: TypeFaceRecyclerView, data: Int) {
            view.setEmptyIconColor(data)
        }


        @BindingAdapter("app:emptyIconHeight")
        @JvmStatic
        fun setEmptyIconHeight(view: TypeFaceRecyclerView, data: Float) {
            view.setImageHeight(ActivityBase.activity.dpToPx(data.toInt()))
        }


        @BindingAdapter("app:emptyIconWidth")
        @JvmStatic
        fun setEmptyIconWidth(view: TypeFaceRecyclerView, data: Float) {
            view.setImageWidth(ActivityBase.activity.dpToPx(data.toInt()))
        }


        @BindingAdapter("app:rightIcon")
        @JvmStatic
        fun setRightIcon(view: ImageView, drawable: Int) {
            if (drawable == 0) {
                view.visibility = View.GONE
            } else {
                view.visibility = View.VISIBLE
                view.setImageResource(drawable)
            }
        }



        @BindingAdapter("app:genderSelection")
        @JvmStatic
        fun GenderSelection(view: TypeFaceTextView, genderId: Int) {
            when (genderId) {
                1 -> view.text = "Male"
                2 -> view.text = "Female"
                3 -> view.text = "Other / GNC"
            }
        }





        @BindingAdapter("app:setFirstLetter")
        @JvmStatic
        fun firstLetter(view: TypeFaceTextView, data: String) {
            if (data.isNotEmpty()) {
                view.text = data[0].toUpperCase().toString()
            }
        }



        @BindingAdapter("app:setDateTime")
        @JvmStatic
        fun loadDateTime(view: TypeFaceTextView, date: String?) {
            if (date != null && !TextUtils.isEmpty(date)) {
                view.text = DateUtil.convertSingleDateSchedule(date)
            }
        }

        @BindingAdapter("app:setNotiDate")
        @JvmStatic
        fun loadNotiTime(view: TypeFaceTextView, date: String) {
            if (date != null && !TextUtils.isEmpty(date)) {
                view.text = DateUtil.convertNotificationSingleDate(getLocalDate(date!!))
            }
        }




        @BindingAdapter("app:setDate")
        @JvmStatic
        fun loadDate(view: TypeFaceTextView, date: String) {
            if (date != null && !TextUtils.isEmpty(date)) {
                view.text = DateUtil.convertDateWithoutTime(date)
            }
        }

        @BindingAdapter("app:setTime")
        @JvmStatic
        fun loadTime(view: TypeFaceTextView, date: String) {
            if (date != null && !TextUtils.isEmpty(date)) {
                view.text = DateUtil.convertSingleTime(date)
            }
        }

        @BindingAdapter("app:setCompleteDateWithTime")
        @JvmStatic
        fun loadDateWithTime(view: TypeFaceTextView, date: String?) {
            if (date != null && !TextUtils.isEmpty(date)) {
                view.text = "${DateUtil.convertDateWithoutTime(date)}"
            }
        }

        @BindingAdapter("app:setCompleteTime")
        @JvmStatic
        fun loadTimeMain(view: TypeFaceTextView, date: String?) {
            if (date != null && !TextUtils.isEmpty(date)) {
                view.text = "${DateUtil.convertSingleTime("$date:00")}"
            }
        }

        @TargetApi(Build.VERSION_CODES.N)
        @BindingAdapter("app:loadHtmlData")
        @JvmStatic
        fun loadHtmlData(view: TypeFaceTextView, data: String) {
            if (data != null && data.isNotEmpty())
                view.text = Html.fromHtml(data, Html.FROM_HTML_MODE_LEGACY)
        }


        @BindingAdapter("app:setHTMLText")
        @JvmStatic
        fun setTextFromHTML(view: TypeFaceTextView, text: String) {
            if (!TextUtils.isEmpty(text)) {
                view.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)
            }
        }

        @BindingAdapter("app:setFloatValue")
        @JvmStatic
        fun setTextFloat(view: TypeFaceTextView, value: Double) {
            view.text = "$${String.format("%.2f", value)}"
        }


        @BindingAdapter("app:setDay")
        @JvmStatic
        fun loadDay(view: TypeFaceTextView, date: String?) {
            if (date != null && !TextUtils.isEmpty(date)) {
                view.text = "${DateUtil.convertDate(date)}"
            }
        }

        @BindingAdapter("app:setMonth")
        @JvmStatic
        fun loadMonth(view: TypeFaceTextView, date: String?) {
            if (date != null && !TextUtils.isEmpty(date)) {
                view.text = "${DateUtil.convertMonth(date)}"
            }
        }

        @BindingAdapter("app:setMonthYear")
        @JvmStatic
        fun loadMonthYear(view: TypeFaceTextView, date: String?) {
            if (date != null && !TextUtils.isEmpty(date)) {
                view.text = "${DateUtil.convertMonthYear(date)}"
            }
        }

        @BindingAdapter("app:setTransactionPrice")
        @JvmStatic
        fun loadPrice(view: TypeFaceTextView, model: Transactions?) {
           if (model != null){
               when(model.transactionType!!) {
                   TransactionType.CREDIT.value -> {
                       view.setTextColor(ContextCompat.getColor(ActivityBase.activity , R.color.blue))
                       view.text = "SAR ${model.transactionAmount}"
                   }
                   TransactionType.DEBIT.value -> {
                       view.setTextColor(ContextCompat.getColor(ActivityBase.activity , R.color.red))
                       view.text = "-SAR ${model.transactionAmount}"
                   }

               }
           }
        }

        @BindingAdapter("app:setPendingFont")
        @JvmStatic
        fun setPending(view: TypeFaceTextView, status: String) {
            if (status.toInt() == OrderStatus.PENDING.value){
                view.setCustomFont(ActivityBase.activity, "poppins_bold.ttf")
            }else {
                view.setCustomFont(ActivityBase.activity, "poppins_regular.ttf")
            }
        }

        @BindingAdapter("app:setAcceptedFont")
        @JvmStatic
        fun setAccepted(view: TypeFaceTextView, status: String) {
            if (status.toInt() == OrderStatus.ACCEPTED.value){
                view.setCustomFont(ActivityBase.activity, "poppins_bold.ttf")
            }else {
                view.setCustomFont(ActivityBase.activity, "poppins_regular.ttf")
            }
        }

        @BindingAdapter("app:setCompletedFont")
        @JvmStatic
        fun setCompleted(view: TypeFaceTextView, status: String) {
            if (status.toInt() == OrderStatus.COMPLETE.value){
                view.setCustomFont(ActivityBase.activity, "poppins_bold.ttf")
            }else {
                view.setCustomFont(ActivityBase.activity, "poppins_regular.ttf")
            }
        }

        @BindingAdapter("app:setFailedFont")
        @JvmStatic
        fun setFailed(view: TypeFaceTextView, status: String) {
            if (status.toInt() == OrderStatus.FAILED.value){
                view.setCustomFont(ActivityBase.activity, "poppins_bold.ttf")
            }else {
                view.setCustomFont(ActivityBase.activity, "poppins_regular.ttf")
            }
        }


        @BindingAdapter("app:setCardColorOrder")
        @JvmStatic
        fun setCardColor(view: CardView, status: String) {

            when(status.toInt()){
                OrderStatus.PENDING.value -> {
                    view.setCardBackgroundColor(ContextCompat.getColor(ActivityBase.activity, R.color.red))
                }

                OrderStatus.ACCEPTED.value -> {
                    view.setCardBackgroundColor(ContextCompat.getColor(ActivityBase.activity, R.color.red))
                }

                OrderStatus.COMPLETE.value -> {
                    view.setCardBackgroundColor(ContextCompat.getColor(ActivityBase.activity, R.color.red))
                }

                OrderStatus.FAILED.value -> {
                    view.setCardBackgroundColor(ContextCompat.getColor(ActivityBase.activity, R.color.red))
                }
            }
        }


      /*  @BindingAdapter("app:setTextColorOrder")
        @JvmStatic
        fun setTextColor(view: TypeFaceTextView, status: String) {

            when(status.toInt()){
                OrderStatus.PENDING.value -> {
                    view.text = ActivityBase.activity.getString(R.string.pending)
                    view.setTextColor(ContextCompat.getColor(ActivityBase.activity, R.color.pending_color))
                }

                OrderStatus.ACCEPTED.value -> {
                    view.text = ActivityBase.activity.getString(R.string.pending)
                    view.setTextColor(ContextCompat.getColor(ActivityBase.activity, R.color.blue))
                }

                OrderStatus.COMPLETE.value -> {
                    view.text = ActivityBase.activity.getString(R.string.pending)
                    view.setTextColor(ContextCompat.getColor(ActivityBase.activity, R.color.pending_color))
                }

                OrderStatus.FAILED.value -> {
                    view.text = ActivityBase.activity.getString(R.string.failed)
                    view.setTextColor(ContextCompat.getColor(ActivityBase.activity, R.color.pending_color))
                }
            }
        }*/

        @BindingAdapter("app:setDayName")
        @JvmStatic
        fun setDayName(view: TypeFaceTextView, date: String) {
            if (DateUtil.isToday(date))
                view.text = "Today"
            else
                view.text = DateUtil.getDayName(date)
        }


        @BindingAdapter("app:setLocalRotation")
        @JvmStatic
        fun setRotation(view: View, date: String) {
            if (DarusslamApp.db.getString(Constants.LANGUAGE).equals(Constants.ARABIC)){
                view.rotation = 180f
            }else {
                view.rotation = 0f
            }
        }

        @BindingAdapter("app:setLocalRotationCoupon")
        @JvmStatic
        fun setRotationCoupon(view: View, date: String) {
            if (DarusslamApp.db.getString(Constants.LANGUAGE).equals(Constants.ARABIC)){
                view.rotation = 90f
            }else {
                view.rotation = 0f
            }
        }


        @BindingAdapter("app:setLocalRotationCheck")
        @JvmStatic
        fun setRotationCheck(view: View, isCheck: Boolean) {
            if (isCheck) {
                view.rotation = 90f
            }else {
                if (DarusslamApp.db.getString(Constants.LANGUAGE).equals(Constants.ARABIC)) {
                    view.rotation = 180f
                }else {
                    view.rotation = 0f
                }
            }
        }

        @BindingAdapter("app:setWalletDate")
        @JvmStatic
        fun loadWalletDater(view: TypeFaceTextView, date: String?) {
            if (date != null && !TextUtils.isEmpty(date)) {
                view.text = "${DateUtil.convertSingleDateWallet(date)}"
            }
        }
    }
}