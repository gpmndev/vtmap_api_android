package com.gpmn.vtmap.api.models.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(@SerializedName("error_message") val errorMessage : String = "",
                         @SerializedName("message") val message : String = "")