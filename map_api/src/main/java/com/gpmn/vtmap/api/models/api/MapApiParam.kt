package com.gpmn.vtmap.api.models.api

class MapApiParam {
    var lat: Double? = null
    var lng: Double? = null
    var address: String? = null
    var placeId: String? = null
    var bounds: String? = null
    var fields: String? = null
    var input: String? = null
    var originLat: Double? = null
    var originLng: Double? = null
    var locationLat: Double? = null
    var locationLng: Double? = null
    var radius: Int? = null
    var keyword: String? = null
    var rankby: String? = null
    var destinationLat: Double? = null
    var destinationLng: Double? = null
    var alternatives = false
    var mode = "driving"
    var waypoints: String? = null

    fun buildLat(lat: Double?): MapApiParam {
        this.lat = lat
        return this
    }

    fun buildLng(lng: Double?): MapApiParam {
        this.lng = lng
        return this
    }

    fun buildAddress(address: String?): MapApiParam {
        this.address = address
        return this
    }

    fun buildPlaceId(placeId: String?): MapApiParam {
        this.placeId = placeId
        return this
    }

    fun buildBounds(bounds: String?): MapApiParam {
        this.bounds = bounds
        return this
    }

    fun buildFields(fields: String?): MapApiParam {
        this.fields = fields
        return this
    }

    fun buildInput(input: String?): MapApiParam {
        this.input = input
        return this
    }

    fun buildOriginLat(originLat: Double?): MapApiParam {
        this.originLat = originLat
        return this
    }

    fun buildOriginLng(originLng: Double?): MapApiParam {
        this.originLng = originLng
        return this
    }

    fun buildLocationLat(locationLat: Double?): MapApiParam {
        this.locationLat = locationLat
        return this
    }

    fun buildLocationLng(locationLng: Double?): MapApiParam {
        this.locationLng = locationLng
        return this
    }

    fun buildRadius(radius: Int?): MapApiParam {
        this.radius = radius
        return this
    }

    fun buildKeyword(keyword: String?): MapApiParam {
        this.keyword = keyword
        return this
    }

    fun buildRankby(rankby: String?): MapApiParam {
        this.rankby = rankby
        return this
    }

    fun buildDestinationLat(destinationLat: Double?): MapApiParam {
        this.destinationLat = destinationLat
        return this
    }

    fun buildDestinationLng(destinationLng: Double?): MapApiParam {
        this.destinationLng = destinationLng
        return this
    }

    fun buildAlternatives(alternatives: Boolean): MapApiParam {
        this.alternatives = alternatives
        return this
    }

    fun buildMode(mode: String): MapApiParam {
        this.mode = mode
        return this
    }

    fun buildWaypoints(waypoints: String?): MapApiParam {
        this.waypoints = waypoints
        return this
    }
}