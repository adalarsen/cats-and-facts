package com.example.storefront

import com.example.storefront.databinding.EpoxyModelCatItemBinding
import com.example.storefront.epoxy.ViewBindingKotlinModel
import com.example.storefront.model.domain.Fact

data class FactEpoxyModel(
    val fact: Fact
): ViewBindingKotlinModel<EpoxyModelCatItemBinding>(R.layout.epoxy_model_cat_item) {
    override fun EpoxyModelCatItemBinding.bind() {
        catTitleTextView.text = fact.text
        catDescriptionTextView.text = fact.text
        catCategoryTextView.text = fact.text

    }
}
