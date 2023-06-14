package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName


data class DetailPlace(
    @SerializedName("address_components") val addressComponents : List<AddressComponent>?,
    @SerializedName("adr_address") val adrAddress: String?,
    @SerializedName("formatted_address") val formattedAddress: String?,
    @SerializedName("geometry") val geometry: Geometry?,
    @SerializedName("icon") val icon: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("opening_hours") val openingHours: OpeningHours?,
    @SerializedName("place_id") override var id: String,
    @SerializedName("plus_code") val plusCode: PlusCode?,
    @SerializedName("price_level") val priceLevel: Int?,
    @SerializedName("rating") val rating: Double?,
    @SerializedName("types") val types: List<String>?,
    @SerializedName("user_rating_total") val userRatingTotal: Int?,
    @SerializedName("vicinity") val vicinity: String?,

    ) : Place()
