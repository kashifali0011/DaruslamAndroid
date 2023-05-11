package com.dtech.darussalam.data.providermodel.responsemodel

import com.google.gson.annotations.SerializedName

data class ProviderProfileResponseModel (

    @SerializedName("id"                ) var id               : Int?                        = null,
    @SerializedName("email"             ) var email            : String?                     = null,
    @SerializedName("phone"             ) var phone            : String?                     = null,
    @SerializedName("name"              ) var name             : String?                     = null,
    @SerializedName("company_name"      ) var companyName      : String?                     = null,
    @SerializedName("reg_number"        ) var regNumber        : String?                     = null,
    @SerializedName("skills"            ) var skills           : String?                     = null,
    @SerializedName("experience"        ) var experience       : String?                     = null,
    @SerializedName("details"           ) var details          : String?                     = null,
    @SerializedName("logo_image"        ) var logoImage        : String?                     = null,
    @SerializedName("service_type"      ) var serviceType      : String?                     = null,
    @SerializedName("address"           ) var address          : String?                     = null,
    @SerializedName("latitude"          ) var latitude         : String?                     = null,
    @SerializedName("longitude"         ) var longitude        : String?                     = null,
    @SerializedName("website"           ) var website          : String?                     = null,
    @SerializedName("provider_services" ) var providerServices : ArrayList<ProviderServices> = arrayListOf(),
    @SerializedName("user_type"         ) var userType         : String?                     = null

)

data class ProviderCategories (

    @SerializedName("category_id"    ) var categoryId    : Int?     = null,
    @SerializedName("category_title" ) var categoryTitle : String?  = null,
    @SerializedName("service_id"     ) var serviceId     : Int?     = null,


)

data class ProviderSubServices (

    @SerializedName("sub_service_id"    ) var subServiceId    : Int?                  = null,
    @SerializedName("sub_service_title" ) var subServiceTitle : String?               = null,
    @SerializedName("categories"        ) var categories      : ArrayList<ProviderCategories> = arrayListOf()

)

data class ProviderServices (

    @SerializedName("service_id"    ) var serviceId    : Int?                   = null,
    @SerializedName("service_title" ) var serviceTitle : String?                = null,
    @SerializedName("service_icon"  ) var serviceIcon  : String?                = null,
    @SerializedName("sub_services"  ) var subServices  : ArrayList<ProviderSubServices> = arrayListOf(),
    var isCheck: Boolean = false

)