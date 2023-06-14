package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class GeocodingPlace(
    @SerializedName("plus_code") val plusCode: PlusCode?,
    @SerializedName("types") val types: List<String>?,
    @SerializedName("geometry") val geometry: Geometry?,
    @SerializedName("formatted_address") val formattedAddress: String?,
    @SerializedName("address_components") val addressComponents: List<AddressComponent>?,
    @SerializedName("place_id") override var id: String
) : Place() {
    override fun toString() = "$plusCode"
}
