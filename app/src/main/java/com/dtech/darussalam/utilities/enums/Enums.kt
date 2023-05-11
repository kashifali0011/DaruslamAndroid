package com.dtech.darussalam.utilities.enums


enum class UserType(val value : Int){
    GUEST(0),CUSTOMER(1),PROVIDER(2)
}

enum class LocationLabel(val value : Int){
    HOME(0),WORK(1),OTHER(2)
}
enum class UpdateProfile(val value: Int){
    CUSTOMER_UPDATE_NAME(1) ,CUSTOMER_UPDATE_EMAIL(2),CUSTOMER_UPDATE_PHONE(3),
    CUSTOMER_UPDATE_PIN(4),CUSTOMER_UPDATE_IMAGE(5)
}

enum class TransactionType(val value : String) {
    DEBIT("debit"), CREDIT("credit")
}
enum class RejectAdditionInvoice(val value: Int){
    REJECT_ADDITION_INVOICE(3) , ACCEPT_ADDITION_INVOICE(2)
}

enum class HomeBottomSheetEnums(val value: Int){
    HOME(1),FAVORITES(2),MORE(3)
}

enum class ProviderDashboardJobsEnums(val value: Int){
    PENDING_JOBS(1),ACCEPTED_JOBS(2),FAILED_JOBS(3),COMPLETED_JOBS(4),TOTAL_JOBS(5)
}

enum class OrderStatus(val value: Int){
    PENDING(1) , ACCEPTED(2) , FAILED(3), COMPLETE(4)
}

enum class BannerType(val value : String) {
    BOTH("both"), PROVIDER("provider"), GENERAL("general"), CASHBACK("cashback") , SERVICE("service") , RECHARGE("recharge") , SIGNUP("signup")
}

enum class DiscountType(val value : String) {
    PERCENTAGE("percentage"), FIX("fix")
}