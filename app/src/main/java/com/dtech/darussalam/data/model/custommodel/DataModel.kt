package com.dtech.darussalam.data.model.custommodel

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

data class ToolbarModel(var isNavigationShown: Boolean, var isBackShown: Boolean, var placesShown: Boolean, var notificationShown: Boolean, var cartShown: Boolean,
                        var userName: String, var title: String, var subTitle: String?, var placeName: String)

data class SetPositionCategoryModel(var isChecked: Boolean = false)
data class SaveCouponModel(var coupon: String = "")
data class SaveCouponApplyModel(var coupon: String = "")
data class SaveNotificationModel(var checkStatus: Int = 0)
data class SaveLocationStatusModel(var check: Int = 0)
data class ProviderOptionList(var number: Int = 0)

@Entity(tableName = "service_table")
data class ServiceDbModel (

    @PrimaryKey(autoGenerate = true) var id                  : Int?              = null,
    @SerializedName("address_latitude"     ) var addressLatitude     : String?           = null,
    @SerializedName("address_longitude"    ) var addressLongitude    : String?           = null,
    @SerializedName("address_title"        ) var addressTitle        : String?           = null,
    @SerializedName("images"               ) var images              : ArrayList<String> = arrayListOf(),
    @SerializedName("cart_service_id"      ) var cartServiceId       : Int?              = null,
    @SerializedName("category_id"          ) var categoryId          : Int?              = null,
    @SerializedName("category_name"        ) var categoryName        : String?           = null,
    @SerializedName("coupon_code"          ) var couponCode          : String?           = null,
    @SerializedName("coupon_id"            ) var couponId            : Int?              = null,
    @SerializedName("date_time"            ) var dateTime            : String?           = null,
    @SerializedName("option_id"            ) var optionId            : ArrayList<Int> = arrayListOf(),
    @SerializedName("service_type"         ) var serviceType         : Int?              = null,
    @SerializedName("provider_id"          ) var providerId          : Int?              = null,
    @SerializedName("provider_name"        ) var providerName        : String?           = null,
    @SerializedName("provider_rating"      ) var providerRating      : String?           = null,
    @SerializedName("service_id"           ) var serviceId           : Int?              = null,
    @SerializedName("service_image"        ) var serviceImage        : String?           = null,
    @SerializedName("service_detail"       ) var serviceDetail       : String?           = null,
    @SerializedName("service_name"         ) var serviceName         : String?           = null,
    @SerializedName("service_instructions" ) var serviceInstructions : String?           = null,
    @SerializedName("service_price"        ) var servicePrice        : String?           = null,
    @SerializedName("slot_id"              ) var slotId              : Int?              = null,
    @SerializedName("discount_percentage"  ) var discountPercentage  : String?           = null,
    @SerializedName("discounted_amount"    ) var discountedAmount    : String?           = null

)

/*
data class NotificationModel(var date : String? , var list : ArrayList<NotificationResponseModel>)

data class ProviderToolbarModel(var title: String , var isBackShown: Boolean , var isToolBarShown : Boolean)

data class DateModel(var date : String , var isSelect : Boolean)*/
