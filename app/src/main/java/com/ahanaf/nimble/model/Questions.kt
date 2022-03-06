package com.ahanaf.nimble.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
class Questions(
    @SerializedName("data")
    var `data`: List<DataX>?
)