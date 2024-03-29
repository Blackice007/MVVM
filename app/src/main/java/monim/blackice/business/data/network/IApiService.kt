package monim.blackice.business.data.network

import io.reactivex.Maybe
import monim.blackice.business.data.model.BaseModel
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface IApiService {


    @GET("{url}")
    abstract fun getRequest(
        @Path(value = "url", encoded = true) path: String,
        @QueryMap hashMap: Map<String, String>
    ): Maybe<BaseModel<Any>>

    @FormUrlEncoded
    @POST("{url}")
    abstract fun postRequest(
        @Path(value = "url", encoded = true) path: String,
        @FieldMap hashMap: Map<String, String>
    ): Maybe<BaseModel<Any>>

    @Multipart
    @Headers("Content-Type:multipart/form-data")
    @POST("{url}")
    abstract fun sendDocuments(
        @Path(value = "url", encoded = true) path: String,
        @PartMap partMap: Map<String, RequestBody>
    ): Maybe<BaseModel<Any>>


    @Headers("Content-Type: application/json")
    @POST("{url}")
    abstract fun postRequestForRaw(
        @Path(value = "url", encoded = true) path: String,
        @Body requestBody: RequestBody
    ): Maybe<Any>


    /* @FormUrlEncoded
    @POST("login")
    abstract fun login(
        @Field("msisdn") msisdn: String,
        @Field("password") password: String
    ): Maybe<BaseModel<Any>>

*/
}