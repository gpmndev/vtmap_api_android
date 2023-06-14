package com.gpmn.vtmap.api.models.map

import com.google.gson.annotations.SerializedName

data class OpeningHours(@SerializedName("opening_now") val openingNow: Boolean = false)