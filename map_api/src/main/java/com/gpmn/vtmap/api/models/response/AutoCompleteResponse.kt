package com.gpmn.vtmap.api.models.response

import com.google.gson.annotations.SerializedName
import com.gpmn.vtmap.api.models.map.AutocompletePlace

data class AutoCompleteResponse(
    @SerializedName("status") val status: String?,
    @SerializedName("predictions") val predictions: List<AutocompletePlace>?
)