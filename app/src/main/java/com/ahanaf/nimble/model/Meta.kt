package com.ahanaf.nimble.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
class Meta(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("page_size")
    var pageSize: Int?,
    @SerializedName("pages")
    var pages: Int?,
    @SerializedName("records")
    var records: Int?
)