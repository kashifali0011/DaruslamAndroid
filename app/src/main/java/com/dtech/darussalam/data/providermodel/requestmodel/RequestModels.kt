package com.dtech.darussalam.data.providermodel.requestmodel

import com.google.gson.annotations.SerializedName

data class SetJobStatusRequestModel (

    @SerializedName("order_service_id" ) var orderServiceId  : Int?    = null,
    @SerializedName("rejection_reason" ) var rejectionReason : String? = null,
    @SerializedName("status"           ) var status          : Int?    = null

)

data class SetAdditionalInvoiceRequestModel (

    @SerializedName("order_service_id" ) var orderServiceId : Int?    = null,
    @SerializedName("price"            ) var price          : Double?    = null,
    @SerializedName("remarks"          ) var remarks        : String? = null

)

data class ProviderSlotsRequestModel(
    @SerializedName("date" ) var date : String?    = null,
)

data class ChangeSlotStatusRequestModel (

    @SerializedName("date"    ) var date   : String? = null,
    @SerializedName("slot_id" ) var slotId : Int?    = null,
    @SerializedName("status"  ) var status : Int?    = null

)