package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class Route (
    @SerializedName("bounds") val bounds : ViewPort?,
    @SerializedName("copyrights") val copyrights : String?,
    @SerializedName("points") val points : List<LatLng>?,
    @SerializedName("summary") val summary : String?,
    @SerializedName("warning") val warning : List<String>?,
    @SerializedName("waypoint_order") val waypointOrder : List<String>? )
