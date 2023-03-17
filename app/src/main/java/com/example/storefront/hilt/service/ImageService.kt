package com.example.storefront.hilt.service

import com.example.storefront.BuildConfig
import com.example.storefront.model.network.NetworkImage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
    @GET("v1/images/search?limit=5")
    @Headers("x-api-key: " + BuildConfig.CATS_KEY)
    suspend fun getAllImages(): Response<List<NetworkImage>>
}