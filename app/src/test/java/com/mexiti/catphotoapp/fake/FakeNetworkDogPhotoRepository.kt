package com.mexiti.catphotoapp.fake


import com.mexiti.catphotoapp.data.DogPhotoRepository
import com.mexiti.catphotoapp.model.DogModel

class FakeNetworkDogPhotoRepository: DogPhotoRepository  {
    override suspend fun getDogPhotos(): List<DogModel> {
        return FakeDataSource.photoList
    }
}