package com.dtech.darussalam.data.providermodel.responsemodel

import com.google.gson.annotations.SerializedName


data class DashboardDataResponseModel (

    @SerializedName("company_name"       ) var companyName       : String?          = null,
    @SerializedName("logo_image"         ) var logoImage         : String?          = null,
    @SerializedName("wallet_balance"     ) var walletBalance     : Double?          = null,
    @SerializedName("notification_count" ) var notificationCount : Int?             = null,
    @SerializedName("stats"              ) var stats             : ArrayList<Stats> = arrayListOf()

)

data class Stats (

    @SerializedName("title"    ) var title   : String? = null,
    @SerializedName("stat"     ) var stat    : Int?    = null,
    @SerializedName("icon"     ) var icon    : String? = null,
    @SerializedName("job_type" ) var jobType : String? = null

)


data class ProviderJobsResponseModel (

    @SerializedName("jobs" ) var jobs : ArrayList<Jobs> = arrayListOf()

)

data class Jobs (

    @SerializedName("order_number"              ) var orderNumber             : Int?    = null,
    @SerializedName("order_status"              ) var orderStatus             : String? = null,
    @SerializedName("name"                      ) var name                    : String? = null,
    @SerializedName("phone"                     ) var phone                   : String? = null,
    @SerializedName("service_title"             ) var serviceTitle            : String? = null,
    @SerializedName("category_title"            ) var categoryTitle           : String? = null,
    @SerializedName("address_title"             ) var addressTitle            : String? = null,
    @SerializedName("order_vat_percentage"      ) var orderVatPercentage      : String? = null,
    @SerializedName("order_discount_percentage" ) var orderDiscountPercentage : String? = null,
    @SerializedName("service_price"             ) var servicePrice            : String? = null,
    @SerializedName("service_time"              ) var serviceTime             : String? = null,
    @SerializedName("transaction_id"            ) var transactionId           : String? = null,
    @SerializedName("order_id"                  ) var orderId                 : String? = null,
    @SerializedName("order_service_id"          ) var orderServiceId          : Int?    = null,
    @SerializedName("payment_type"              ) var paymentType             : String? = null,
    @SerializedName("base_price"                ) var basePrice               : String? = null,
    @SerializedName("discount_percentage"       ) var discountPercentage      : Double?    = null,
    @SerializedName("discount_amount"           ) var discountAmount          : Double?    = null,
    @SerializedName("vat_percentage"            ) var vatPercentage           : String? = null,
    @SerializedName("vat_amount"                ) var vatAmount               : Double?    = null,
    @SerializedName("total_amount"              ) var totalAmount             : String? = null

)

data class JobDetailResponseModel (

    @SerializedName("service_title"                ) var serviceTitle              : String?                    = null,
    @SerializedName("name"                         ) var name                      : String?                    = null,
    @SerializedName("phone"                        ) var phone                     : String?                    = null,
    @SerializedName("address"                      ) var address                   : String?                    = null,
    @SerializedName("latitude"                     ) var latitude                  : String?                    = null,
    @SerializedName("longitude"                    ) var longitude                 : String?                    = null,
    @SerializedName("teansaction"                  ) var teansaction               : String?                    = null,
    @SerializedName("time"                         ) var time                      : String?                    = null,
    @SerializedName("payment_type"                 ) var paymentType               : String?                    = null,
    @SerializedName("service_type"                 ) var serviceType               : String?                    = null,
    @SerializedName("description"                  ) var description               : String?                    = null,
    @SerializedName("question_answers"             ) var questionAnswers           : ArrayList<QuestionAnswers> = arrayListOf(),
    @SerializedName("images"                       ) var images                    : ArrayList<ImagesModel>          = arrayListOf(),
    @SerializedName("order_id"                     ) var orderId                   : String?                    = null,
    @SerializedName("order_number"                 ) var orderNumber               : String?                    = null,
    @SerializedName("order_service_id"             ) var orderServiceId            : String?                    = null,
    @SerializedName("payment_details"              ) var paymentDetails            : PaymentDetails?            = PaymentDetails(),
    @SerializedName("is_additional_invoice_marked" ) var isAdditionalInvoiceMarked : Int?                       = null,
    @SerializedName("is_complete_allowed"          ) var isCompleteAllowed         : Int?                       = null,
    @SerializedName("coupon_code"                  ) var couponCode                : String?                    = null,
    @SerializedName("invoice_url"                  ) var invoiceUrl                : String?                    = null,
    @SerializedName("additional_invoice_url"       ) var additionalInvoiceUrl      : String?                    = null,
    @SerializedName("category_title"               ) var categoryTitle             : String?                    = null,
    @SerializedName("reject_reason"               ) var rejectReason             : String?                    = null

)

data class ImagesModel (

    @SerializedName("order_service_id" ) var orderServiceId : String? = null,
    @SerializedName("image_title"      ) var imageTitle     : String? = null

)

data class QuestionAnswers (

    @SerializedName("answers_detail"   ) var answersDetail  : String? = null,
    @SerializedName("question_title"   ) var questionTitle  : String? = null,
    @SerializedName("order_service_id" ) var orderServiceId : Int?    = null,
    @SerializedName("question_id"      ) var questionId     : Int?    = null

)

data class PaymentDetails (

    @SerializedName("base_price"                  ) var basePrice                 : String? = null,
    @SerializedName("discount_percentage"         ) var discountPercentage        : String? = null,
    @SerializedName("discount_amount"             ) var discountAmount            : Double? = null,
    @SerializedName("additional_invoice"          ) var additionalInvoice         : Double? = null,
    @SerializedName("additional_invoice_vat"      ) var additionalInvoiceVat      : String? = null,
    @SerializedName("additional_invoice_discount" ) var additionalInvoiceDiscount : String? = null,
    @SerializedName("vat_percentage"              ) var vatPercentage             : String? = null,
    @SerializedName("vat_amount"                  ) var vatAmount                 : String? = null,
    @SerializedName("total_amount"                ) var totalAmount               : String? = null,
    @SerializedName("amount_to_be_collected"      ) var amountToBeCollected       : String? = null,
    @SerializedName("wallet_amount"               ) var walletAmount             : Double? = null

)

data class ProviderTimeSlotsResponseModel (

    @SerializedName("slots" ) var slots : ArrayList<ProviderSlots> = arrayListOf()

)

data class ProviderSlots (

    @SerializedName("slot_id"        ) var slotId        : Int?    = null,
    @SerializedName("slot_time_from" ) var slotTimeFrom  : String? = null,
    @SerializedName("slot_time_to"   ) var slotTimeTo    : String? = null,
    @SerializedName("week_day"       ) var weekDay       : String? = null,
    @SerializedName("booking_status" ) var bookingStatus : Int?    = null

)