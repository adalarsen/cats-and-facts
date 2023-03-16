package com.example.storefront

import android.util.Log
import com.airbnb.epoxy.Typed2EpoxyController
import com.example.storefront.model.domain.Fact
import com.example.storefront.model.domain.Image

class CatEpoxyController: Typed2EpoxyController<List<Image>, List<Fact>>() {

    override fun buildModels(data1: List<Image>?, data2: List<Fact>?) {
        if (data1 == null || data1.isEmpty() || data2 == null || data2.isEmpty()) {
            return
        }
        Log.i("Facts: ", data2.size.toString())

        data1.forEach { image ->
            ImageEpoxyModel(image).id(image.id).addTo(this)
        }

        data2.forEach { fact ->
            FactEpoxyModel(fact).id(fact.id).addTo(this)
        }



    }


}
