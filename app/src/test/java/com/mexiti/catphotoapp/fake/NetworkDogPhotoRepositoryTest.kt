package com.mexiti.catphotoapp.fake

import com.mexiti.catphotoapp.data.NetworkDogPhotoRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class NetworkDogPhotoRepositoryTest {
    @Test
    fun networkDogPhotoRepository_getDogPhotos_verifyPhotoList(){
        runTest {
            val repository = NetworkDogPhotoRepository(
                dogApiService = FakeDogApiService()
            )
            assertEquals(FakeDataSource.photoList,repository.getDogPhotos())

        }


    }

}