package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class PlusCode(
    @SerializedName("global_code") val globalCode: String?,
    @SerializedName("compound_code") val compoundCode: String?
)
