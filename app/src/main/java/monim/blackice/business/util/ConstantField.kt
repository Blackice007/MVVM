package monim.blackice.business.util

import retrofit2.http.Field


class ConstantField {

    var PHONE_NO = "Phone"
    var ACCESS_TOKEN = "token"
    var USER_NAME = "User name"
    var USER_EMAIL = "User email"
    var USER_PROFILE_IMAGE = "Profile image"
    var USER_MERCHANT_ID = "merchant_id"
    var IS_LOGIN = "isLogin"


    var CUSTOMER_PHONE_NO = "CustomerPhone"
    var CUSTOMER_PHONE_NO_WITHOUT_88 = "CustomerPhoneWithout88"
    var BUNDLE = "bundle"
    var REDEEM_POINTS = "redeemPoints"
    var COUPON = "coupon"
    var POINTS = "points"
    var AMOUNT = "amount"
    var ORDER_ID = "orderId"


    //ENDPOINT
    var ENDPOINT_MSISDN = "msisdn"
    var ENDPOINT_PASSWORD = "password"


    companion object {
        private var constantField = ConstantField()
        fun newInstance(): ConstantField {
            return constantField
        }
    }
}