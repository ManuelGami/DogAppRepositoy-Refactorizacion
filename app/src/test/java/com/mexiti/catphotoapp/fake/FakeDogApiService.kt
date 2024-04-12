package com.mexiti.catphotoapp.fake

import com.mexiti.catphotoapp.model.DogModel
import com.mexiti.catphotoapp.network.DogApiService

class FakeDogApiService:DogApiService {
    override suspend fun getPhotos():List<DogModel>{
        return FakeDataSource.photoList
    }
}