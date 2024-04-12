package com.mexiti.catphotoapp.fake


import com.mexiti.catphotoapp.rules.TestDispatcherRule
import com.mexiti.catphotoapp.ui.viewmodel.DogUiState
import com.mexiti.catphotoapp.ui.viewmodel.DogViewModel

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class DogViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
    @Test
    fun dogViewModel_getDogPhotos_verifyDogUiStateSuccess(){
        runTest {
            val dogViewModel = DogViewModel(
                dogPhotoRepository = FakeNetworkDogPhotoRepository()
            )
            assertEquals(DogUiState.Success(FakeDataSource.photoList),dogViewModel.dogUiState)
        }
    }

}