package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class LatLng(
    @SerializedName("lat") var lat: Double,
    @SerializedName("lng") var lng: Double, private var isValid: Boolean = false,
    val isDefault: Boolean = false,
    private val isReceiveNow: Boolean = false
) {
    private var _receiveTimestamp: Long? = null

    init {
        if (-90 > lat || lat > 90 || -180 > lng || lng > 180) {
            this.isValid = false;
            this.lat = 0.0;
            this.lng = 0.0;
        } else {
            isValid = true;
        }
        if (this.isReceiveNow) {
            _receiveTimestamp = System.currentTimeMillis()
        }
    }

    override fun toString(): String = "lat:$lat, lng:$lng"
}

