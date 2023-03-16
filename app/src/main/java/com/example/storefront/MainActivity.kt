package com.example.storefront

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.storefront.databinding.ActivityMainBinding
import com.example.storefront.hilt.service.FactService
import com.example.storefront.hilt.service.ImageService
import com.example.storefront.model.domain.Fact
import com.example.storefront.model.domain.Image
import com.example.storefront.model.mapper.FactMapper
import com.example.storefront.model.mapper.ImageMapper
import com.example.storefront.model.network.NetworkFact
import com.example.storefront.model.network.NetworkImage
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var imageService: ImageService
    @Inject
    lateinit var factService: FactService


    @Inject
    lateinit var imageMapper: ImageMapper
    @Inject
    lateinit var factMapper: FactMapper

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val controller = CatEpoxyController()
        binding.epoxyRecyclerView.setController(controller)

        lifecycleScope.launchWhenStarted {
            val response: Response<List<NetworkImage>> = imageService.getAllImages()
            val responseFact: Response<List<NetworkFact>> = factService.getAllFacts()

            val domainImages: List<Image> = response.body()!!.map {
                imageMapper.buildFrom(it)
            }
            Log.i("Size of images: ", domainImages.size.toString())
            val domainFacts: List<Fact> = responseFact.body()!!.map {
                factMapper.buildFrom(it)
            }
            Log.i("Size of fact: ", domainFacts.size.toString())

            controller.setData(domainImages, domainFacts)
        }


    }







}