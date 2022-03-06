package com.ahanaf.nimble.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
class Attributes(
    @SerializedName("active_at")
    var activeAt: String?,
    @SerializedName("cover_image_url")
    var coverImageUrl: String?,
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("inactive_at")
    var inactiveAt: Any?,
    @SerializedName("is_active")
    var isActive: Boolean?,
    @SerializedName("survey_type")
    var surveyType: String?,
    @SerializedName("thank_email_above_threshold")
    var thankEmailAboveThreshold: String?,
    @SerializedName("thank_email_below_threshold")
    var thankEmailBelowThreshold: String?,
    @SerializedName("title")
    var title: String?
){
//    constructor(title:String, description:String)  {
//        this.title = title
//        this.description =description
//    }
}