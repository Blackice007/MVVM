package monim.blackice.business.data.network

import sslwireless.android.easy.loyal.merchant.viewmodel.util.ApiCallbackHelper


interface IApiHelper {
    fun apiLogin(msisdn: String, password: String,apiCallbackHelper: ApiCallbackHelper)
}