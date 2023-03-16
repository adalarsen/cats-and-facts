package com.example.storefront.model.mapper

import com.example.storefront.model.domain.Cat
import com.example.storefront.model.domain.Fact
import com.example.storefront.model.domain.Image
import com.example.storefront.model.network.NetworkFact
import com.example.storefront.model.network.NetworkImage
import javax.inject.Inject

class ImageMapper @Inject constructor() {
    fun buildFrom(networkImage: NetworkImage): Image {
        return Image (
            id = networkImage.id,
            url = networkImage.url
        )
    }
}

