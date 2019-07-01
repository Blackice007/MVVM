package monim.blackice.business.data.network

import io.reactivex.schedulers.Schedulers
import monim.blackice.business.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory {


    companion object {
        internal fun providePostApi(): IApiService {
            val retrofit: Retrofit =
                provideRetrofitInterface()
            return retrofit.create(IApiService::class.java)
        }

        internal fun provideRetrofitInterface(): Retrofit {

            var client: OkHttpClient.Builder = OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-Type", "application/json")

                    chain.proceed(request.build())
                }
                .addInterceptor(DefaultInterceptors().httpNoneLoggingInterceptor)

            return Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(client.build())
                .build()
        }

        class DefaultInterceptors {

            val httpBodyLoggingInterceptor: HttpLoggingInterceptor
                get() {
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.level = HttpLoggingInterceptor.Level.BODY
                    return interceptor
                }

            val httpNoneLoggingInterceptor: HttpLoggingInterceptor
                get() {
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.level = HttpLoggingInterceptor.Level.NONE
                    return interceptor
                }
        }


    }

}