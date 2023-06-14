package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class AddressComponent(
    @SerializedName("types") val types: List<String>?,
    @SerializedName("long_name") val longName: String?,
    @SerializedName("short_name") val shortName: String?,
    @SerializedName("area_code") val areaCode: String?
)
