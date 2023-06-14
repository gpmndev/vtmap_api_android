package com.gpmn.vtmap.api

import com.google.gson.Gson
import com.gpmn.vtmap.api.models.api.MapAPIConfig
import com.gpmn.vtmap.api.models.api.MapApiParam
import com.gpmn.vtmap.api.models.api.CancelRequest
import com.gpmn.vtmap.api.models.response.*
import com.gpmn.vtmap.api.services.MapsAPIService
import com.gpmn.vtmap.api.services.RetrofitHelper
import kotlinx.coroutines.*
import okhttp3.ResponseBody

class ViettelMapApi(apiKey: String? = null, baseUrl: String? = null) {
    private var mapsAPIService: MapsAPIService =
        RetrofitHelper.getInstance(MapAPIConfig(baseUrl, apiKey)).create(MapsAPIService::class.java)

    fun geocode(
        apiParam: MapApiParam? = null,
        onSuccess: ((result: GeocodeResponse?) -> Unit)? = null,
        onFailure: ((message: String?) -> Unit)? = null,
        onCanceledRequest: (() -> Unit)? = null
    ): CancelRequest {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            try {
                val result = mapsAPIService.geocode(
                    lat_lng = "${apiParam?.lat},${apiParam?.lng}",
                    address = apiParam?.address,
                    placeId = apiParam?.placeId,
                    bounds = apiParam?.bounds
                )

                if (result.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        onSuccess?.invoke(result.body())
                    }
                } else {
                    handleFailureResponse(result.errorBody(), onFailure)
                }
            } catch (exception: Exception) {
                if (scope.coroutineContext.job.isCancelled) {
                    CoroutineScope(Dispatchers.Main).launch {
                        onCanceledRequest?.invoke()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        onFailure?.invoke(exception.message)
                    }
                }
            } finally {
                cancel()
            }
        }


        val cancelRequest = CancelRequest()
        cancelRequest.scope = scope
        return cancelRequest
    }

    fun autocomplete(
        apiParam: MapApiParam? = null,
        onSuccess: ((result: AutoCompleteResponse?) -> Unit)? = null,
        onFailure: ((message: String?) -> Unit)? = null,
        onCanceledRequest: (() -> Unit)? = null,
    ): CancelRequest {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch(Dispatchers.IO) {
            try {
                val result = mapsAPIService.autocomplete(
                    origin = "${apiParam?.originLat},${apiParam?.originLng}",
                    location = "${apiParam?.locationLat},${apiParam?.locationLng}",
                    radius = apiParam?.radius,
                    input = apiParam?.input,
                )

                if (result.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        onSuccess?.invoke(result.body())
                    }
                } else {
                    handleFailureResponse(result.errorBody(), onFailure)
                }
            } catch (exception: Exception) {
                if (scope.coroutineContext.job.isCancelled) {
                    CoroutineScope(Dispatchers.Main).launch {
                        onCanceledRequest?.invoke()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        onFailure?.invoke(exception.message)
                    }
                }
            } finally {
                cancel()
            }
        }

        val cancelRequest = CancelRequest()
        cancelRequest.scope = scope
        return cancelRequest
    }

    fun placeDetail(
        apiParam: MapApiParam? = null,
        onSuccess: ((result: PlaceDetailResponse?) -> Unit)? = null,
        onFailure: ((message: String?) -> Unit)? = null,
        onCanceledRequest: (() -> Unit)? = null,
    ): CancelRequest {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch(Dispatchers.IO) {
            try {
                val result = mapsAPIService.placeDetail(
                    placeId = apiParam?.placeId, fields = apiParam?.fields
                )

                if (result.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        onSuccess?.invoke(result.body())
                    }
                } else {
                    handleFailureResponse(result.errorBody(), onFailure)
                }
            } catch (exception: Exception) {
                if (scope.coroutineContext.job.isCancelled) {
                    CoroutineScope(Dispatchers.Main).launch {
                        onCanceledRequest?.invoke()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        onFailure?.invoke(exception.message)
                    }
                }
            } finally {
                cancel()
            }
        }

        val cancelRequest = CancelRequest()
        cancelRequest.scope = scope
        return cancelRequest
    }

    fun nearBySearch(
        apiParam: MapApiParam? = null,
        onSuccess: ((result: NearbySearchResponse?) -> Unit)? = null,
        onFailure: ((message: String?) -> Unit)? = null,
        onCanceledRequest: (() -> Unit)? = null,
    ): CancelRequest {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch(Dispatchers.IO) {
            try {
                val result = mapsAPIService.nearbySearch(
                    location = "${apiParam?.locationLat},${apiParam?.locationLng}",
                    rankBy = apiParam?.rankby,
                    radius = apiParam?.radius
                )

                if (result.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        onSuccess?.invoke(result.body())
                    }
                } else {
                    handleFailureResponse(result.errorBody(), onFailure)
                }
            } catch (exception: Exception) {
                if (scope.coroutineContext.job.isCancelled) {
                    CoroutineScope(Dispatchers.Main).launch {
                        onCanceledRequest?.invoke()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        onFailure?.invoke(exception.message)
                    }
                }
            } finally {
                cancel()
            }
        }

        val cancelRequest = CancelRequest()
        cancelRequest.scope = scope
        return cancelRequest
    }

    fun direction(
        mapApiParam: MapApiParam? = null,
        onSuccess: ((result: DirectionResponse?) -> Unit)? = null,
        onFailure: ((message: String?) -> Unit)? = null,
        onCanceledRequest: (() -> Unit)? = null,
    ): CancelRequest {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch(Dispatchers.IO) {
            try {
                val result = mapsAPIService.direction(
                    origin = "${mapApiParam?.originLat},${mapApiParam?.locationLng}",
                    destination = "${mapApiParam?.destinationLat},${mapApiParam?.destinationLng}",
                    mode = mapApiParam?.mode,
                    alternatives = mapApiParam?.alternatives,
                    waypoints = mapApiParam?.waypoints
                )

                if (result.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        onSuccess?.invoke(result.body())
                    }
                } else {
                    handleFailureResponse(result.errorBody(), onFailure)
                }
            } catch (exception: Exception) {
                if (scope.coroutineContext.job.isCancelled) {
                    CoroutineScope(Dispatchers.Main).launch {
                        onCanceledRequest?.invoke()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        onFailure?.invoke(exception.message)
                    }
                }
            } finally {
                cancel()
            }
        }

        val cancelRequest = CancelRequest()
        cancelRequest.scope = scope
        return cancelRequest
    }

    private suspend fun handleFailureResponse(
        errorBody: ResponseBody?, onFailure: ((message: String?) -> Unit)?
    ) {
        val body = errorBody?.string()
        if (body.isNullOrEmpty()) {
            withContext(Dispatchers.Main) {
                onFailure?.invoke("Không xác định được lỗi!")
            }
        } else {
            try {
                val errorResponse = Gson().fromJson(body, ErrorResponse::class.java)
                withContext(Dispatchers.Main) {
                    onFailure?.invoke(
                        if (errorResponse.errorMessage.isEmpty()) {
                            errorResponse.message
                        } else {
                            errorResponse.errorMessage
                        }
                    )
                }
            } catch (exception: Exception) {
                withContext(Dispatchers.Main) {
                    onFailure?.invoke("Có lỗi xảy ra")
                }
            }
        }
    }
}
