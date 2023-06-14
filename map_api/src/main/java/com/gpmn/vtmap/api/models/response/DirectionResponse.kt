package com.gpmn.vtmap.api.models.response

import com.google.gson.annotations.SerializedName
import com.gpmn.vtmap.api.models.map.GeocodeWaypoint
import com.gpmn.vtmap.api.models.map.Route

data class DirectionResponse(
    @SerializedName("status") val status : String?,
    @SerializedName("geocoded_waypoints") val geocodedWaypoints: List<GeocodeWaypoint>?,
    @SerializedName("routes") val routes: List<Route>?
)