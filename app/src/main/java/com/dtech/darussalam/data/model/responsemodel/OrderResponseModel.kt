package com.dtech.darussalam.data.model.responsemodel


import com.dtech.darussalam.data.model.custommodel.ServiceDbModel
import com.google.gson.annotations.SerializedName

data class ApplyCouponResponseModel (

    @SerializedName("services" ) var services : ArrayList<ServiceDbModel> = arrayListOf(),
    @SerializedName("extras"   ) var extras   : Extras?             = Extras(),
    @SerializedName("wallet"   ) var wallet   : Wallet?             = Wallet(),
    @SerializedName("coupon_error" ) var couponError : ArrayList<CouponError> = arrayListOf()

)

data class Services (

    @SerializedName("address_latitude"     ) var addressLatitude     : String?           = null,
    @SerializedName("address_longitude"    ) var addressLongitude    : String?           = null,
    @SerializedName("address_title"        ) var addressTitle        : String?           = null,
    @SerializedName("images"               ) var images              : ArrayList<String> = arrayListOf(),
    @SerializedName("cart_service_id"      ) var cartServiceId       : Int?              = null,
    @SerializedName("category_id"          ) var categoryId          : Int?              = null,
    @SerializedName("coupon_code"          ) var couponCode          : String?           = null,
    @SerializedName("coupon_id"            ) var couponId            : Int?              = null,
    @SerializedName("date_time"            ) var dateTime            : String?           = null,
    @SerializedName("option_id"            ) var optionId            : String?           = null,
    @SerializedName("service_type"         ) var serviceType         : Int?              = null,
    @SerializedName("answers"              ) var answers             : ArrayList<String> = arrayListOf(),
    @SerializedName("provider_id"          ) var providerId          : Int?              = null,
    @SerializedName("service_id"           ) var serviceId           : Int?              = null,
    @SerializedName("service_instructions" ) var serviceInstructions : String?           = null,
    @SerializedName("service_price"        ) var servicePrice        : String?           = null,
    @SerializedName("slot_id"              ) var slotId              : Int?              = null,
    @SerializedName("discount_percentage"  ) var discountPercentage  : String?           = null,
    @SerializedName("discounted_amount"    ) var discountedAmount    : String?           = null

)


data class Extras (

    @SerializedName("services_total"   ) var servicesTotal   : String? = null,
    @SerializedName("discounted_total" ) var discountedTotal : String? = null,
    @SerializedName("discount_amount"  ) var discountAmount  : String? = null,
    @SerializedName("vat_percentage"   ) var vatPercentage   : String? = null,
    @SerializedName("vat_amount"       ) var vatAmount       : String? = null

)


data class Wallet (

    @SerializedName("wallet_id"  ) var walletId  : Int?    = null,
    @SerializedName("user_id"    ) var userId    : Int?    = null,
    @SerializedName("balance"    ) var balance   : Double?    = null,
    @SerializedName("created_at" ) var createdAt : String? = null,
    @SerializedName("updated_at" ) var updatedAt : String? = null

)

data class CouponError (

    @SerializedName("coupon_code"   ) var couponCode   : String? = null,
    @SerializedName("is_expired"    ) var isExpired    : Int?    = null,
    @SerializedName("not_found"     ) var notFound     : Int?    = null,
    @SerializedName("customer_used" ) var customerUsed : Int?    = null

)

data class PlaceOrderResponseModel (

    @SerializedName("order_details" ) var orderDetails : OrderDetails? = OrderDetails()

)

data class OrderDetails (

    @SerializedName("order_number" ) var orderNumber : String? = null,
    @SerializedName("order_id"     ) var orderId     : Int?    = null,
    @SerializedName("amount"       ) var amount      : String? = null

)


data class GetBankHostedUrlResponseModel (

    @SerializedName("GatewayUrl" ) var gatewayUrl : String? = null

)

data class DecryptPaymentResponse (

    @SerializedName("status_code" ) var statusCode : Int?    = null,
    @SerializedName("message"     ) var message    : String? = null,
    @SerializedName("data"        ) var data       : DataArb?   = DataArb()

)

data class ArbResponse (

    @SerializedName("authRespCode"     ) var authRespCode     : String? = null,
    @SerializedName("trackId"          ) var trackId          : String? = null,
    @SerializedName("transId"          ) var transId          : String?    = null,
    @SerializedName("udf5"             ) var udf5             : String? = null,
    @SerializedName("cardType"         ) var cardType         : String? = null,
    @SerializedName("udf6"             ) var udf6             : String? = null,
    @SerializedName("udf10"            ) var udf10            : String? = null,
    @SerializedName("amt"              ) var amt              : String? = null,
    @SerializedName("udf3"             ) var udf3             : String? = null,
    @SerializedName("udf4"             ) var udf4             : String? = null,
    @SerializedName("udf1"             ) var udf1             : String? = null,
    @SerializedName("udf2"             ) var udf2             : String? = null,
    @SerializedName("result"           ) var result           : String? = null,
    @SerializedName("expMonth"         ) var expMonth         : String? = null,
    @SerializedName("udf9"             ) var udf9             : String? = null,
    @SerializedName("expYear"          ) var expYear          : String? = null,
    @SerializedName("paymentId"        ) var paymentId        : String?    = null,
    @SerializedName("udf7"             ) var udf7             : String? = null,
    @SerializedName("udf8"             ) var udf8             : String? = null,
    @SerializedName("fcCustId"         ) var fcCustId         : String? = null,
    @SerializedName("actionCode"       ) var actionCode       : String? = null,
    @SerializedName("card"             ) var card             : String? = null,
    @SerializedName("paymentTimestamp" ) var paymentTimestamp : String? = null

)

data class DataArb (

    @SerializedName("ArbResponse" ) var ArbResponse : ArbResponse? = ArbResponse()

)

data class WalletSummaryResponseModel (

    @SerializedName("wallet_id"          ) var walletId          : Int?                    = null,
    @SerializedName("user_id"            ) var userId            : Int?                    = null,
    @SerializedName("balance"            ) var balance           : Double?                    = null,
    @SerializedName("created_at"         ) var createdAt         : String?                 = null,
    @SerializedName("updated_at"         ) var updatedAt         : String?                 = null,
    @SerializedName("transactions_count" ) var transactionsCount : Int?                    = null,
    @SerializedName("total_spent"        ) var totalSpent        : Double?                    = null,
    @SerializedName("transactions"       ) var transactions      : ArrayList<Transactions> = arrayListOf()

)

data class Transactions (

    @SerializedName("wallet_transaction_id" ) var walletTransactionId : Int?    = null,
    @SerializedName("wallet_id"             ) var walletId            : Int?    = null,
    @SerializedName("order_id"              ) var orderId             : String? = null,
    @SerializedName("before"                ) var before              : Double? = null,
    @SerializedName("transaction_amount"    ) var transactionAmount   : Double? = null,
    @SerializedName("after"                 ) var after               : Double?    = null,
    @SerializedName("transaction_type"      ) var transactionType     : String? = null,
    @SerializedName("transaction_detail"    ) var transactionDetail   : String? = null,
    @SerializedName("transaction_id"        ) var transactionId       : String? = null,
    @SerializedName("comment"               ) var comment             : String? = null,
    @SerializedName("is_system_transaction" ) var isSystemTransaction : Int?    = null,
    @SerializedName("transaction_date"      ) var transactionDate     : String? = null,
    @SerializedName("deleted_at"            ) var deletedAt           : String? = null,
    @SerializedName("created_at"            ) var createdAt           : String? = null,
    @SerializedName("updated_at"            ) var updatedAt           : String? = null

)

data class WalletTransactionResponseModel (

    @SerializedName("transactions" ) var transactions : ArrayList<WalletTransactions> = arrayListOf()

)
data class WalletTransactions (

    @SerializedName("date"    ) var date    : String?            = null,
    @SerializedName("details" ) var details : ArrayList<Transactions> = arrayListOf()

)