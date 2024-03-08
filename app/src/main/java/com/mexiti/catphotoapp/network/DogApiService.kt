package com.mexiti.dogphotoapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

import com.mexiti.catphotoapp.model.DogModel
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

import retrofit2.http.GET

private const val BASE_URL= " https://api.thedogapi.com/"

private val retrofit=Retrofit.Builder()

    .addConverterFactory(Json.asConverterFactory("aplication/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()
interface DogApiService{
    //aqui ya estamos interactuando con la API
    @GET("v1/images/search?limit=10")//leemos la respuesta de la api, la busca en internet
    suspend fun getPhotos():List<DogModel>// es la calse de lista de datos Dataclass

}

//patron de dise;o singleton
// se ocupa un solo objeto cada que se cree la api en lugar de crear una cada vez
object DogApi{
    val retrofitService:DogApiService by lazy {
        retrofit.create(DogApiService::class.java)
    }
}