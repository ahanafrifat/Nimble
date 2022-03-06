package com.ahanaf.nimble.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
class DataX(
    @SerializedName("id")
    var id: String?,
    @SerializedName("type")
    var type: String?
)