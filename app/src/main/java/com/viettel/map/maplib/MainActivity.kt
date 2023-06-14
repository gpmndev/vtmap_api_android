package com.viettel.map.maplib

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gpmn.vtmap.api.ViettelMapApi
import com.gpmn.vtmap.api.models.api.MapApiParam
import com.gpmn.vtmap.api.models.api.CancelRequest

class MainActivity : AppCompatActivity() {
    private lateinit var btGeocoding: Button
    private lateinit var btAutoComplete: Button
    private lateinit var btPlaceDetail: Button
    private lateinit var btNearBy: Button
    private lateinit var btDirection: Button

    private lateinit var btCancelGeocoding: Button
    private lateinit var btCancelAutoComplete: Button
    private lateinit var btCancelPlaceDetail: Button
    private lateinit var btCancelNearBy: Button
    private lateinit var btCancelDirection: Button

    private lateinit var tvTest: TextView

    private val getMapApi = ViettelMapApi()

    private var cancelRequestGeocoding = CancelRequest()
    private var cancelRequestAutoComplete = CancelRequest()
    private var cancelRequestPlaceDetail = CancelRequest()
    private var cancelRequestNearby = CancelRequest()
    private var cancelRequestDirection = CancelRequest()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btGeocoding = findViewById(R.id.btGeocoding)
        btAutoComplete = findViewById(R.id.btAutoComplete)
        btPlaceDetail = findViewById(R.id.btPlaceDetail)
        btNearBy = findViewById(R.id.btNearby)
        btDirection = findViewById(R.id.btDirection)

        btCancelGeocoding = findViewById(R.id.btCancelGeocoding)
        btCancelAutoComplete = findViewById(R.id.btCancelAutoComplete)
        btCancelPlaceDetail = findViewById(R.id.btCancelPlaceDetail)
        btCancelNearBy = findViewById(R.id.btCancelNearby)
        btCancelDirection = findViewById(R.id.btCancelDirection)

        tvTest = findViewById(R.id.tvTest)

        btCancelGeocoding.setOnClickListener {
            cancelRequestGeocoding.cancel()
        }

        btCancelAutoComplete.setOnClickListener {
            cancelRequestAutoComplete.cancel()
        }

        btCancelPlaceDetail.setOnClickListener {
            cancelRequestPlaceDetail.cancel()
        }

        btCancelNearBy.setOnClickListener {
            cancelRequestNearby.cancel()
        }

        btCancelDirection.setOnClickListener {
            cancelRequestDirection.cancel()
        }

        btGeocoding.setOnClickListener {
            getMapApi.geocode(
                MapApiParam().apply {
                    lat = 10.773775968700647
                    lng = 106.68621473014355
                },
                onFailure = {
                    Log.d("MainActivity", "failure $it")
                    tvTest.text = it.toString()
                },
                onSuccess = {
                    Log.d("MainActivity", "success $it")
                    tvTest.text = it.toString()
                },
                //cancelRequest = cancelRequestGeocoding,
                onCanceledRequest = {
                    Log.d("MainActivity", "request cancel")
                    tvTest.text = "request cancel"
                }
            )
        }

        btAutoComplete.setOnClickListener {
            getMapApi.autocomplete(
                MapApiParam().apply {
                    input = "cong an quan 3"
                    radius = 1000
                    locationLat = 10.773775968700647
                    locationLng = 106.68621473014355
                },
                onFailure = {
                    Log.d("MainActivity", "failure $it")
                },
                onSuccess = {
                    Log.d("MainActivity", "success $it")
                },
                onCanceledRequest = {
                    Log.d("MainActivity", "request cancel")
                })
        }

        btPlaceDetail.setOnClickListener {
            getMapApi.placeDetail(
                MapApiParam().apply {
                    placeId =
                        "65794a7762326c66615751694f6a4d794e6a63324c434a7762326c6664486c775a5349364d544e39"
                    fields = "place_id"
                },
                onFailure = {
                    Log.d("MainActivity", "failure $it")
                },
                onSuccess = {
                    Log.d("MainActivity", "success $it")
                },
                onCanceledRequest = {
                    Log.d("MainActivity", "request cancel")
                }
            )
        }

        btNearBy.setOnClickListener {
            getMapApi.nearBySearch(
                MapApiParam().apply {
                    locationLat = 16.0665
                    locationLng = 108.2159
                    radius = 1000
                    rankby = "distance"
                },
                onFailure = {
                    Log.d("MainActivity", "failure $it")
                },
                onSuccess = {
                    Log.d("MainActivity", "success $it")
                },
                onCanceledRequest = {
                    Log.d("MainActivity", "request cancel")
                }
            )
        }

        btDirection.setOnClickListener {
            getMapApi.direction(
                MapApiParam().apply {
                    originLat = 16.073977
                    originLng = 108.214190
                    destinationLat = 16.074245
                    destinationLng = 108.217183
                    alternatives = false
                },
                onFailure = {
                    Log.d("MainActivity", "failure $it")
                },
                onSuccess = {
                    Log.d("MainActivity", "success $it")
                },
                onCanceledRequest = {
                    Log.d("MainActivity", "request cancel")
                }
            )
        }
    }
}
