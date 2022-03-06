package com.ahanaf.nimble.network.retrofit

import com.ahanaf.nimble.common.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallbackHandler<T>(private val onSuccess: (onSuccess: T) -> Unit, private val onError: (onError: ResponseModel) -> Unit) :
    Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {
        when {
            response.code() == 200 -> {
                onSuccess.invoke(response.body()!!)
            }
            response.code() == 204 -> {
                onError.invoke(ResponseModel("Found nothing", response.code()))
            }
            else -> {
                onError.invoke(ResponseModel(response.message(), response.code()))
            }
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onError.invoke(ResponseModel("Couldn't Connect", 4))
    }
}