package com.dtech.darussalam.data.model.requestmodel

import com.dtech.darussalam.data.model.custommodel.ServiceDbModel
import com.google.gson.annotations.SerializedName

data class LoginRequestModel(var phone: String, var pin: String, var user_type: Int, var device_token: String)

data class VerifyPhoneRequestModel(var country_code: String, var phone: String, var user_type : Int)

data class VerifyOtpRequestModel(var phone : String, var otp_code : String , var forgot_pin : Boolean?)

data class BasicInfoRequestModel(var full_name : String, var email : String , var pin : String, var phone : String)

data class CreatePinRequestModel(var phone : String, var pin : String)

data class ForgotPinRequestModel(var phone : String)

data class ServiceCategoriesRequestModel(var service_id:Int)

data class ServiceCategoriesDetailFormRequestModel(var service_id:Int, var category_id:Int)

data class UpdateCustomerProfile(var key: Int, var value: String)

data class UpdateProfileVerifyOtp(var otp_code : String)

data class ResendCodeModel(var type: Int, var value: String)

data class UpdatePinModel(var otp_code: String , var pin: String)

data class DeleteCustomerModel(var pin: String )


data class SaveAddressRequestModel (

    @SerializedName("latitude"            ) var latitude           : Double? = null,
    @SerializedName("longitude"           ) var longitude          : Double? = null,
    @SerializedName("address_name"        ) var addressName        : String? = null,
    @SerializedName("address_title"       ) var addressTitle       : String? = null,
    @SerializedName("address_description" ) var addressDescription : String? = null,
    @SerializedName("street"              ) var street             : String? = null,
    @SerializedName("floor"               ) var floor              : String? = null,
    @SerializedName("provider_note"       ) var providerNote       : String? = null

)

data class DeleteAddressRequestModel(var address_id : Int)

data class UpdateAddressRequestModel(
    @SerializedName("latitude"            ) var latitude           : Double? = null,
    @SerializedName("longitude"           ) var longitude          : Double? = null,
    @SerializedName("address_name"        ) var addressName        : String? = null,
    @SerializedName("address_title"       ) var addressTitle       : String? = null,
    @SerializedName("address_description" ) var addressDescription : String? = null,
    @SerializedName("street"              ) var street             : String? = null,
    @SerializedName("floor"               ) var floor              : String? = null,
    @SerializedName("provider_note"       ) var providerNote       : String? = null,
    @SerializedName("address_id"          ) var addressId          : String? = null
)

data class GetProviderRequestModel (
    @SerializedName("date"           ) var date         : String? = null,
    @SerializedName("sort_price_dsc" ) var sortPriceDsc : Int?    = null,
    @SerializedName("sort_price_asc" ) var sortPriceAsc : Int?    = null,
    @SerializedName("sort_rating"    ) var sortRating   : String? = null,
    @SerializedName("latitude"       ) var latitude     : Double? = null,
    @SerializedName("service_type"   ) var serviceType  : String? = null,
    @SerializedName("category_id"    ) var categoryId   : Int?    = null,
    @SerializedName("options"        ) var options      : ArrayList<Int>? = null,
    @SerializedName("time"           ) var time         : String? = null,
    @SerializedName("longitude"      ) var longitude    : Double? = null

)

data class GetProviderDetailRequestModel (
    @SerializedName("date"        ) var date       : String? = null,
    @SerializedName("service_id"  ) var serviceId  : Int?    = null,
    @SerializedName("provider_id" ) var providerId : Int?    = null

)


data class ApplyCouponRequestModel (

    @SerializedName("coupon_codes" ) var couponCodes : ArrayList<String> = arrayListOf(),
    @SerializedName("customer_id"  ) var customerId  : Int? = null,
    @SerializedName("services"     ) var services    : ArrayList<ServiceDbModel> = arrayListOf()

)


data class PlaceOrderRequestModel (

    @SerializedName("extras" ) var extras : Extras? = Extras(),
    @SerializedName("services"     ) var services    : ArrayList<ServiceDbModel> = arrayListOf()

)


data class Extras (

    @SerializedName("base_amount"               ) var baseAmount              : String?           = null,
    @SerializedName("coupon_codes"              ) var couponCodes             : ArrayList<String> = arrayListOf(),
    @SerializedName("customer_id"               ) var customerId              : Int?              = null,
    @SerializedName("discount_amount"           ) var discountAmount          : String?           = null,
    @SerializedName("order_discount_percentage" ) var orderDiscountPercentage : String?           = null,
    @SerializedName("order_instructions"        ) var orderInstructions       : String?           = null,
    @SerializedName("order_type"                ) var orderType               : Int?              = null,
    @SerializedName("total_amount"              ) var totalAmount             : String?           = null,
    @SerializedName("transaction_id"            ) var transactionId           : String?           = null,
    @SerializedName("vat_amount"                ) var vatAmount               : String?           = null,
    @SerializedName("vat_percentage"            ) var vatPercentage           : String?           = null

)


data class GetBankHostedUrlRequestModel (

    @SerializedName("amount"           ) var amount          : Double? = null,
    @SerializedName("order_number"     ) var orderNumber     : String? = null,
    @SerializedName("type"             ) var type            : Int?    = null,
    @SerializedName("transaction_type" ) var transactionType : Int?    = null

)
data class AdditionInvoiceModel(var status: String , var transaction_id: String , var additional_cost_id: String)

data class TopupWalletRequestModel(var amount : String)

data class LeadRequestModel (

    @SerializedName("service_time" ) var serviceTime : String? = null,
    @SerializedName("service_date" ) var serviceDate : String? = null,
    @SerializedName("service_id"   ) var serviceId   : Int?    = null,
    @SerializedName("category_id"  ) var categoryId  : Int?    = null,
    @SerializedName("address"      ) var address     : String? = null,
    @SerializedName("option_id"    ) var optionId    : ArrayList<Int> = arrayListOf(),

)


