package com.example.storefront.model.mapper

import com.example.storefront.model.domain.Cat
import com.example.storefront.model.network.NetworkFact
import com.example.storefront.model.network.NetworkImage
import javax.inject.Inject

class CatMapper @Inject constructor() {
    fun buildFrom(networkImage: NetworkImage, networkFact: NetworkFact): Cat {
        return Cat (
            id = networkImage.id,
            url = networkImage.url,
            text = networkFact.text
        )
    }
}

