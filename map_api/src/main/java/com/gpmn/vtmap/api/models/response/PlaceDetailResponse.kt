package com.gpmn.vtmap.api.models.response

import com.google.gson.annotations.SerializedName
import com.gpmn.vtmap.api.models.map.DetailPlace

data class PlaceDetailResponse(
    @SerializedName("status") val status: String?,
    @SerializedName("html_attributions") val htmlAttributions: String?,
    @SerializedName("result") val result: DetailPlace
)