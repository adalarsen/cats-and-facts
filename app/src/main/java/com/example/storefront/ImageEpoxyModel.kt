package com.example.storefront

import androidx.core.view.isGone
import androidx.core.view.isVisible
import coil.load
import com.example.storefront.databinding.EpoxyModelCatItemBinding
import com.example.storefront.epoxy.ViewBindingKotlinModel
import com.example.storefront.model.domain.Image

data class ImageEpoxyModel(
    val image: Image
): ViewBindingKotlinModel<EpoxyModelCatItemBinding>(R.layout.epoxy_model_cat_item) {
    override fun EpoxyModelCatItemBinding.bind() {


        imageViewLoadingProgressBar.isVisible = true
        imageView.load(
            data = image.url
        ){
            listener { _, _ ->
                imageViewLoadingProgressBar.isGone = true
            }
        }
    }
}
