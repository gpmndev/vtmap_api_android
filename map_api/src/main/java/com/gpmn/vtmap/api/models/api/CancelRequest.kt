package com.gpmn.vtmap.api.models.api

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

class CancelRequest {
    var scope : CoroutineScope? = null
    fun cancel() {
        scope?.cancel()
        scope = null
    }
}