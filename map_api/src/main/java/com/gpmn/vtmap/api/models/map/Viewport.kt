package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class ViewPort(
    @SerializedName("northeast") val northeast: LatLng?,
    @SerializedName("southwest") val southwest: LatLng?
)