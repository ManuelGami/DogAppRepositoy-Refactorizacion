package com.mexiti.catphotoapp.data

import com.mexiti.catphotoapp.model.DogModel

import com.mexiti.catphotoapp.network.DogApiService

interface DogPhotoRepository {
    suspend fun  getDogPhotos():List<DogModel>
}
class NetworkDogPhotoRepository(private val dogApiService: DogApiService) : DogPhotoRepository{
    override suspend fun getDogPhotos(): List<DogModel> =dogApiService.getPhotos()
    }
