package com.ahanaf.nimble.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
class SurveyListResponse(
    @SerializedName("data")
    var surveyList: List<Survey>?,
    @SerializedName("meta")
    var meta: Meta?
)