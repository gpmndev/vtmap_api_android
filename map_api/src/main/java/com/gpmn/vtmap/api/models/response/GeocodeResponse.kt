package com.gpmn.vtmap.api.models.response

import com.google.gson.annotations.SerializedName
import com.gpmn.vtmap.api.models.map.GeocodingPlace

data class GeocodeResponse(
    @SerializedName("status") val status: String,
    @SerializedName("results") val results: List<GeocodingPlace>
)