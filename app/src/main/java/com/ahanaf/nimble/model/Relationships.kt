package com.ahanaf.nimble.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
class Relationships(
    @SerializedName("questions")
    var questions: Questions?
)