package com.dtech.darussalam.data.remote

import com.dtech.darussalam.data.model.requestmodel.*
import com.dtech.darussalam.data.model.responsemodel.*
import com.dtech.done.doneapp.data.model.responsemodel.*
import com.dtech.darussalam.data.providermodel.requestmodel.ChangeSlotStatusRequestModel
import com.dtech.darussalam.data.providermodel.requestmodel.ProviderSlotsRequestModel
import com.dtech.darussalam.data.providermodel.requestmodel.SetAdditionalInvoiceRequestModel
import com.dtech.darussalam.data.providermodel.requestmodel.SetJobStatusRequestModel
import com.dtech.darussalam.data.providermodel.responsemodel.*

import com.dtech.darussalam.utilities.Constants
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

/*    @POST(Constants.VERIFY_PHONE_URL)
    fun verifyPhone(@Body body: VerifyPhoneRequestModel): Call<ApiResponse<GeneralModel>>

    @POST(Constants.VERIFY_OTP)
    fun verifyOtp(@Body body: VerifyOtpRequestModel): Call<ApiResponse<VerifyOtpResponseModel>>*/


/*
    @POST(Constants.GET_TIME_SLOT)
    fun getProviderDetails(@Body body: GetProviderDetailRequestModel): Call<ApiResponse<GetProviderDetailResponseModel>>

    @POST(Constants.GET_ALL_SERVICES_LIST)
    fun getAllServicesList() :Call<ApiResponse<ServiceData>>

    @POST(Constants.GET_SERVICE_CATEGORIES)
    fun getServicesCategories(@Body body: ServiceCategoriesRequestModel):Call<ApiResponse<ServiceCategories>>

    @POST(Constants.GET_SERVICE_DETAIL_FORM)
    fun getServiceCategoriesDetailForm(@Body body: ServiceCategoriesDetailFormRequestModel):Call<ApiResponse<Data>>

    @Multipart
    @POST(Constants.UPLOAD_IMAGE)
    fun uploadImage( @Part file: ArrayList<MultipartBody.Part?>):Call<ApiResponse<ArrayList<String>>>

    @GET(Constants.GET_SETTING)
    fun getSettings(): Call<ApiResponse<SettingData>>

    @POST(Constants.APPLY_COUPON)
    fun applyCoupon(@Body body: ApplyCouponRequestModel):Call<ApiResponse<ApplyCouponResponseModel>>

    @POST(Constants.PLACE_ORDER)
    fun placeOrder(@Body body: PlaceOrderRequestModel):Call<ApiResponse<PlaceOrderResponseModel>>

    @POST(Constants.GET_BANK_HOSTED_URL)
    fun getBankHostedUrl(@Body body: GetBankHostedUrlRequestModel):Call<ApiResponse<GetBankHostedUrlResponseModel>>

    @GET("${Constants.GET_CUSTOMER_ORDER}/{orderStatus}")
    fun getCustomerOrderList(@Path("orderStatus") orderStatus: String, @Query("page") pageNumber: String): Call<ApiResponse<MyOrderListDetails>>

    @GET(Constants.PROFILE)
    fun getCustomerProfile(): Call<ApiResponse<ProfileResponseModel>>

    @POST(Constants.UPDATE_PROFILE)
    fun updateCustomerProfile(@Body body: UpdateCustomerProfile): Call<ApiResponse<GeneralModel>>

    @POST(Constants.OTP_VERIFY)
    fun updateCustomerProfileVerifyOtp(@Body body: UpdateProfileVerifyOtp): Call<ApiResponse<GeneralModel>>

    @POST(Constants.OTP_VERIFY_PIN)
    fun updatePin(@Body body: UpdatePinModel): Call<ApiResponse<GeneralModel>>

    @POST(Constants.RESEND_CODE)
    fun resendCode(@Body body: ResendCodeModel): Call<ApiResponse<GeneralModel>>

    @Multipart
    @POST(Constants.UPDATE_PROFILE)
    fun uploadCustomerImage(@Part file: MultipartBody.Part? ,@Part("key") key: RequestBody?):Call<ApiResponse<GeneralModel>>

    @GET(Constants.GET_WALLET_SUMMARY)
    fun getWalletSummary(): Call<ApiResponse<WalletSummaryResponseModel>>

    @GET(Constants.WALLET_TRANSACTIONS)
    fun getWalletTransaction(): Call<ApiResponse<WalletTransactionResponseModel>>

    @GET(Constants.GET_NOTIFICATIONS)
    fun getNotifications(): Call<ApiResponse<ArrayList<NotificationResponseModel>>>

    @HTTP(method = "DELETE", path = Constants.DELETE_CUSTOMER, hasBody = true)
    fun deleteCustomer(@Body body: DeleteCustomerModel): Call<ApiResponse<GeneralModel>>

    @GET(Constants.GET_ADDITION_INVOICE)
    fun getAdditionInvoice(): Call<ApiResponse<ArrayList<AdditionInvoiceDetail>>>

    @POST(Constants.CHANGE_ADDITION_COST_STATUS)
    fun rejectAdditionInvoice(@Body body: AdditionInvoiceModel): Call<ApiResponse<GeneralModel>>


    @POST(Constants.TOPUP_WALLET)
    fun topupWallet(@Body body : TopupWalletRequestModel) : Call<ApiResponse<GeneralModel>>

    @GET(Constants.GET_DASHBOARD_DATA)
    fun dashboardData() : Call<ApiResponse<DashboardDataResponseModel>>

    @GET("${Constants.PROVIDER_JOBS}/{orderStatus}")
    fun getProviderJobs(@Path("orderStatus") orderStatus: Int, @Query("page") pageNumber: String): Call<ApiResponse<ProviderJobsResponseModel>>

    @GET("${Constants.JOB_DETAIL}/{id}")
    fun getJobDetail(@Path("id") id: String): Call<ApiResponse<JobDetailResponseModel>>

    @POST(Constants.SET_JOB_STATUS)
    fun setJobStatus(@Body body : SetJobStatusRequestModel) : Call<ApiResponse<GeneralModel>>

    @POST(Constants.SET_ADDITIONAL_INVOICE)
    fun setJAdditionalInvoice(@Body body : SetAdditionalInvoiceRequestModel) : Call<ApiResponse<GeneralModel>>

    @POST(Constants.PROVIDER_SLOTS)
    fun providerSlots(@Body body : ProviderSlotsRequestModel) : Call<ApiResponse<ProviderTimeSlotsResponseModel>>

    @POST(Constants.CHANGE_SLOT_STATUS)
    fun changeSlotStatus(@Body body : ChangeSlotStatusRequestModel) : Call<ApiResponse<GeneralModel>>

    @GET(Constants.PROVIDER_PROFILE)
    fun getProviderProfile() : Call<ApiResponse<ProviderProfileResponseModel>>

    @POST(Constants.DELETE_PROVIDER)
    fun deleteProvider(@Body body: DeleteCustomerModel): Call<ApiResponse<GeneralModel>>

    @POST(Constants.ADD_LEAD)
    fun addLead(@Body body: LeadRequestModel): Call<ApiResponse<GeneralModel>>

    @POST(Constants.GET_PROMOTIONAL_BANNERS)
    fun getPromotionalBanners(): Call<ApiResponse<ArrayList<PromotionalBannerResponseModel>>>*/
}