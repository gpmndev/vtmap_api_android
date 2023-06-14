package com.gpmn.vtmap.api.models.response

import com.google.gson.annotations.SerializedName
import com.gpmn.vtmap.api.models.map.NearbyPlace

data class NearbySearchResponse(
    @SerializedName("status") val status: String?,
    @SerializedName("html_attributions") val htmlAttributions: String?,
    @SerializedName("next_page_token") val nextPageToken: String?,
    @SerializedName("results") val results: List<NearbyPlace>?
)
