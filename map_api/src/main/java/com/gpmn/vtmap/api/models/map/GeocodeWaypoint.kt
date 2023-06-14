package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class GeocodeWaypoint(
    @SerializedName("geocoder_status") val geocoderStatus: String?,
    @SerializedName("place_id") val place_id: String?,
    @SerializedName("types") val types: List<String>?
)