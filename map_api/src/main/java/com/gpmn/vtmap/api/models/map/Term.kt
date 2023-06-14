package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class Term(
    @SerializedName("offset") val offset: Int?,
    @SerializedName("value") val value: String?
)