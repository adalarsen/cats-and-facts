package com.example.storefront.hilt

import com.example.storefront.hilt.service.FactService
import com.example.storefront.hilt.service.ImageService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.Duration
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    @Named("Image")
    fun providesRetrofitImage(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("Fact")
    fun providesRetrofitFact(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://cat-fact.herokuapp.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient() : OkHttpClient {
        val duration = Duration.ofSeconds(15)
        return OkHttpClient.Builder()
            .connectTimeout(duration)
            .readTimeout(duration)
            .writeTimeout(duration)
            .build()
    }

    @Provides
    @Singleton
    fun providesFactService(@Named("Fact") retrofit: Retrofit): FactService {
        return retrofit.create(FactService::class.java)
    }

    @Provides
    @Singleton
    fun providesImageService(@Named("Image") retrofit: Retrofit): ImageService {
        return retrofit.create(ImageService::class.java)
    }
}