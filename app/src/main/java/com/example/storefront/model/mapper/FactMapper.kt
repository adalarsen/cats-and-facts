package com.example.storefront.model.mapper

import com.example.storefront.model.domain.Cat
import com.example.storefront.model.domain.Fact
import com.example.storefront.model.network.NetworkFact
import com.example.storefront.model.network.NetworkImage
import javax.inject.Inject

class FactMapper @Inject constructor() {
    fun buildFrom(networkFact: NetworkFact): Fact {
        return Fact (
            id = networkFact._id,
            text = networkFact.text
        )
    }
}

