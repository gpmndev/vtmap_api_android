package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class Geometry(
    @SerializedName("location") val location: LatLng?,
    @SerializedName("location_type") val locationType: String?,
    @SerializedName("viewport") val viewPort: ViewPort?
)
