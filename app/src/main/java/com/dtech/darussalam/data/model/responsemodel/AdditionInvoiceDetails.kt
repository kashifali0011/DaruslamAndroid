package com.dtech.darussalam.data.model.responsemodel

import com.google.gson.annotations.SerializedName
data class AdditionInvoiceDetail (
    @SerializedName("additional_cost_id"              ) var additionalCostId             : Int?    = null,
    @SerializedName("additional_remarks"              ) var additionalRemarks            : String? = null,
    @SerializedName("additional_price"                ) var additionalPrice              : String? = null,
    @SerializedName("additional_cost_status"          ) var additionalCostStatus         : Int?    = null,
    @SerializedName("additional_cost_vat_amount"      ) var additionalCostVatAmount      : String? = null,
    @SerializedName("wallet_amount"                   ) var walletAmount                 : String? = null,
    @SerializedName("logo_image"                      ) var logoImage                    : String? = null,
    @SerializedName("service_title"                   ) var serviceTitle                 : String? = null,
    @SerializedName("category_title"                  ) var categoryTitle                : String? = null,
    @SerializedName("provider_name"                   ) var providerName                 : String? = null,
    @SerializedName("order_service_id"                ) var orderServiceId               : Int?    = null,
    @SerializedName("vat_percentage"                  ) var vatPercentage                : String? = null,
    @SerializedName("discount_percentage"             ) var discountPercentage           : String? = null,
    @SerializedName("additional_cost_discount_amount" ) var additionalCostDiscountAmount : String? = null,
    @SerializedName("discount_amount"                 ) var discountAmount               : String? = null,
    @SerializedName("vat_amount"                      ) var vatAmount                    : String? = null,
    @SerializedName("total_amount"                    ) var totalAmount                  : String? = null,
    @SerializedName("order_number"                    ) var orderNumber                  : Int?    = null,
    @SerializedName("service_time"                    ) var serviceTime                  : String? = null,
    @SerializedName("address_title"                   ) var addressTitle                 : String? = null,
    @SerializedName("payment_method"                  ) var paymentMethod                : String? = null,
    @SerializedName("order_total"                     ) var orderTotal                   : String? = null
)