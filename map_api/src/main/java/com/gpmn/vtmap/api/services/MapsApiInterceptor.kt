package com.gpmn.vtmap.api.services

import com.gpmn.vtmap.api.models.api.MapAPIConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class MapsAPIInterceptor(private val config: MapAPIConfig) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val httpUrl: HttpUrl = original.url()

        val newHttpUrl : HttpUrl = httpUrl.newBuilder().addQueryParameter("key", config.apiKey).build()

        val requestBuilder : Request.Builder = original.newBuilder().url(newHttpUrl)

        val request = requestBuilder.build()

        return chain.proceed(request)
    }
}