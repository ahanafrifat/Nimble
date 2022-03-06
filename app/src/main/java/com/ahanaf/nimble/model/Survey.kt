package com.ahanaf.nimble.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
class Survey(
    @SerializedName("attributes")
    var attributes: Attributes?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("relationships")
    var relationships: Relationships?,
    @SerializedName("type")
    var type: String?
)