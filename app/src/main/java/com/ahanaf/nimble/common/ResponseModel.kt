package com.ahanaf.nimble.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class ResponseModel {
    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("statusCode")
    @Expose
    var statusCode:Int? = null

    constructor() {}

    constructor(message: String?, statusCode: Int?) {
        this.message = message
        this.statusCode = statusCode
    }
}