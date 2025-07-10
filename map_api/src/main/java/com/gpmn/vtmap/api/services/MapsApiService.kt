package com.gpmn.vtmap.api.services

import com.gpmn.vtmap.api.models.response.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MapsAPIService {
    @GET("placeapi/v2/place-api/geocode")
    suspend fun geocode(
        @Query("latlng") lat_lng: String? = null,
        @Query("address") address: String? = null,
        @Query("place_id") placeId: String? = null,
        @Query("bounds") bounds: String? = null
    ): Response<GeocodeResponse>

    @GET("placeapi/v2/place-api/details")
    suspend fun placeDetail(
        @Query("place_id") placeId: String? = null,
        @Query("fields") fields: String? = null,
    ): Response<PlaceDetailResponse>

    @GET("placeapi/v2/place-api/autocomplete")
    suspend fun autocomplete(
        @Query("input") input: String? = null,
        @Query("origin") origin: String? = null,
        @Query("location") location: String? = null,
        @Query("radius") radius: Int? = null,
    ): Response<AutoCompleteResponse>


    @GET("placeapi/v2/place-api/nearbysearch")
    suspend fun nearbySearch(
        @Query("location") location: String? = null,
        @Query("radius") radius: Int? = null,
        @Query("keyword") keyword: String? = null,
        @Query("rankby") rankBy: String? = null,
    ): Response<NearbySearchResponse>

    @GET("routing/v2/directions")
    suspend fun direction(
        @Query("origin") origin: String? = null,
        @Query("destination") destination: String? = null,
        @Query("alternatives") alternatives: Boolean? = false,
        @Query("mode") mode: String? = "driving",
        @Query("waypoints") waypoints: String? = null
    ): Response<DirectionResponse>
}

interface MapsAPIServiceV4 {
    @GET("placeapi/v4/place-api/geocode")
    suspend fun geocode(
        @Query("latlng") lat_lng: String? = null,
        @Query("address") address: String? = null,
        @Query("place_id") placeId: String? = null,
        @Query("bounds") bounds: String? = null
    ): Response<GeocodeResponse>

    @GET("placeapi/v4/place-api/details")
    suspend fun placeDetail(
        @Query("place_id") placeId: String? = null,
        @Query("fields") fields: String? = null,
    ): Response<PlaceDetailResponse>

    @GET("placeapi/v4/place-api/autocomplete")
    suspend fun autocomplete(
        @Query("input") input: String? = null,
        @Query("origin") origin: String? = null,
        @Query("location") location: String? = null,
        @Query("radius") radius: Int? = null,
    ): Response<AutoCompleteResponse>


    @GET("placeapi/v4/place-api/nearbysearch")
    suspend fun nearbySearch(
        @Query("location") location: String? = null,
        @Query("radius") radius: Int? = null,
        @Query("keyword") keyword: String? = null,
        @Query("rankby") rankBy: String? = null,
    ): Response<NearbySearchResponse>

    @GET("routing/v4/directions")
    suspend fun direction(
        @Query("origin") origin: String? = null,
        @Query("destination") destination: String? = null,
        @Query("alternatives") alternatives: Boolean? = false,
        @Query("mode") mode: String? = "driving",
        @Query("waypoints") waypoints: String? = null
    ): Response<DirectionResponse>
}
