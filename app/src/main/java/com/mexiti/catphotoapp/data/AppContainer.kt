package com.mexiti.catphotoapp.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mexiti.catphotoapp.network.DogApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val dogPhotoRepository:DogPhotoRepository
}
class DefaultAppContainer:AppContainer{

    private val BASE_URL= " https://api.thedogapi.com/"

    private val retrofit=Retrofit.Builder()

        .addConverterFactory(Json.asConverterFactory("aplication/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()
    private val retrofitService: DogApiService by lazy{
        retrofit.create(DogApiService::class.java)
    }
    override val dogPhotoRepository: DogPhotoRepository by lazy {
        NetworkDogPhotoRepository(retrofitService)
    }

}