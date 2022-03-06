package com.ahanaf.nimble.network.retrofit

import com.ahanaf.nimble.common.ResponseModel
import com.ahanaf.nimble.util.BASE_URL_PRODUCTION
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val REQUEST_TIMEOUT = 1
    private var retrofit: Retrofit? = null

    val api: Api get() = getApiClient().create(Api::class.java)

    private fun getApiClient(): Retrofit {
        if (retrofit == null) {
            val okHttpClientBuilder = OkHttpClient.Builder()
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClientBuilder.addInterceptor(logging)
            okHttpClientBuilder
                .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
                .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
                .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.MINUTES)
                .build()

            val ignoreUnknownProperties = GsonBuilder().setExclusionStrategies().create()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL_PRODUCTION)
                .addConverterFactory(GsonConverterFactory.create(ignoreUnknownProperties))
                .client(okHttpClientBuilder.build())
                .build()
        }

        return retrofit!!
    }

    fun <T> Call<T>.call(onSuccess: (onSuccess: T) -> Unit, onError: (onError: ResponseModel) -> Unit) {
        enqueue(CallbackHandler(onSuccess, onError))
    }
}