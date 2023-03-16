package com.example.storefront.hilt.service

import com.example.storefront.model.network.NetworkFact
import retrofit2.Response
import retrofit2.http.GET

interface FactService {
    @GET("facts")
    suspend fun getAllFacts(): Response<List<NetworkFact>>
}