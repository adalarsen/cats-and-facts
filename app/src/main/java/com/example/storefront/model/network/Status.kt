package com.example.storefront.model.network

data class Status(
    val feedback: String,
    val sentCount: Int,
    val verified: Boolean
)