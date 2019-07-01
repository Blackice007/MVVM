package monim.blackice.business.data.network

import io.reactivex.Maybe
import monim.blackice.business.data.model.BaseModel
import monim.blackice.business.data.network.api_call_factory.ApiGetCall
import monim.blackice.business.data.network.api_call_factory.ApiPostCall
import monim.blackice.business.data.network.api_call_factory.ApiPostCallWithDocument
import sslwireless.android.easy.loyal.merchant.viewmodel.util.ApiCallbackHelper

class ApiHelper(apiService: IApiService) : IApiHelper {

    val apiService = apiService

    //call type
    val CALL_TYPE_GET = "get"
    val CALL_TYPE_POST = "post"
    val CALL_TYPE_POST_WITH_DOCUMENT = "post with document"

    //endpoint
    val ENDPOINT_LOGIN = "login"

    //api method field key
    val KEY_MSISDN = "msisdn"
    val KEY_PASSWORD = "password"

    override fun apiLogin(msisdn: String, password: String, apiCallbackHelper: ApiCallbackHelper) {
        Thread(Runnable {
            val hashMap = HashMap<String, String>()
            hashMap.put(KEY_MSISDN, msisdn)
            hashMap.put(KEY_PASSWORD, password)
            getApiCallObservable(CALL_TYPE_POST, ENDPOINT_LOGIN, hashMap)!!.subscribe(apiCallbackHelper)
        }).start()
    }

    fun <T> getApiCallObservable(callType: String, path: String, hashMap: HashMap<String, T>): Maybe<BaseModel<Any>>? {
        if (callType.equals(CALL_TYPE_GET)) {
            return ApiGetCall().getMaybeObserVable(apiService, path, hashMap)
        }
        if (callType.equals(CALL_TYPE_POST)) {
            return ApiPostCall().getMaybeObserVable(apiService, path, hashMap)

        } else if (callType.equals(CALL_TYPE_POST_WITH_DOCUMENT)) {
            return ApiPostCallWithDocument().getMaybeObserVable(apiService, path, hashMap)

        }
        return null
    }

}