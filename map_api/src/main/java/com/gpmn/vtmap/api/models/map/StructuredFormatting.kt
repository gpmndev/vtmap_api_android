package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class StructuredFormatting(
    @SerializedName("main_text") val mainText: String?,
    @SerializedName("secondary_text") val secondaryText: String?
)
