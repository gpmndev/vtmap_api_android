package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class AutocompletePlace(
    @SerializedName("description") val description: String?,
    @SerializedName("structured_formatting") val structuredFormatting: StructuredFormatting?,
    @SerializedName("terms") val terms: List<Term>?,
    @SerializedName("types") val types: List<String>?,
    @SerializedName("place_id") override var id: String
) : Place()
