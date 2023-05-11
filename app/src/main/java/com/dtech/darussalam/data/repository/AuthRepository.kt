package com.dtech.darussalam.data.repository

import com.dtech.darussalam.DarusslamApp
import com.dtech.darussalam.data.model.requestmodel.*
import com.dtech.darussalam.data.model.responsemodel.LoginUserResponseModel
import com.dtech.darussalam.data.model.responsemodel.VerifyOtpResponseModel
import com.dtech.darussalam.data.remote.SingleEnqueueCall
import com.dtech.darussalam.data.remote.callback.IGenericCallBack
import com.dtech.darussalam.utilities.Constants
import com.dtech.darussalam.utilities.helper.SingleLiveData


class AuthRepository : IGenericCallBack {

    var failureMessage: SingleLiveData<String> = SingleLiveData()
    var generalResponse: SingleLiveData<String> = SingleLiveData()
    var verifyOtpResponse: SingleLiveData<VerifyOtpResponseModel> = SingleLiveData()
    var loginResponse: SingleLiveData<LoginUserResponseModel> = SingleLiveData()


  /*  fun verifyPhone(obj : VerifyPhoneRequestModel){
        val call = DarusslamApp.apiService.verifyPhone(obj)
        SingleEnqueueCall.callRetrofit(call, Constants.VERIFY_PHONE_URL, true, this)
    }

    fun verifyOtp(obj : VerifyOtpRequestModel){
        val call = DarusslamApp.apiService.verifyOtp(obj)
        SingleEnqueueCall.callRetrofit(call, Constants.VERIFY_OTP, true, this)
    }*/

   /* fun basicInfo(obj : BasicInfoRequestModel){
        val call = DarusslamApp.apiService.basicInfo(obj)
        SingleEnqueueCall.callRetrofit(call, Constants.BASIC_INFO, true, this)
    }*/

   /* fun createPin(obj : CreatePinRequestModel){
        val call = DarusslamApp.apiService.createPin(obj)
        SingleEnqueueCall.callRetrofit(call, Constants.CREATE_PIN, true, this)
    }

    fun login(obj : LoginRequestModel){
        val call = DarusslamApp.apiService.login(obj)
        SingleEnqueueCall.callRetrofit(call, Constants.LOGIN_URL, true, this)
    }

    fun forgotPin(obj : ForgotPinRequestModel){
        val call = DoneApp.apiService.forgotPin(obj)
        SingleEnqueueCall.callRetrofit(call, Constants.FORGOT_PIN_URL, true, this)
    }

    fun resendOtp(obj : ForgotPinRequestModel){
        val call = DoneApp.apiService.resendOtp(obj)
        SingleEnqueueCall.callRetrofit(call, Constants.RESEND_OTP, true, this)
    }
    fun deleteCustomer(obj: DeleteCustomerModel){
        val call = DoneApp.apiService.deleteCustomer(obj)
        SingleEnqueueCall.callRetrofit(call , Constants.DELETE_CUSTOMER , true , this)
    }*/


    override fun success(apiName: String, response: Any?) {
        when(apiName){
          /*  Constants.VERIFY_PHONE_URL -> {
                val responseModel = response as String
                generalResponse.postValue(responseModel)
            }

            Constants.BASIC_INFO -> {
                val responseModel = response as String
                generalResponse.postValue(responseModel)
            }

            Constants.VERIFY_OTP -> {
                val responseModel = response as VerifyOtpResponseModel
                verifyOtpResponse.postValue(responseModel)
            }

            Constants.CREATE_PIN -> {
                val responseModel = response as String
                generalResponse.postValue(responseModel)
            }*/


        }
    }

    override fun failure(apiName: String, message: String?) {
        failureMessage.postValue(message!!)
    }


}