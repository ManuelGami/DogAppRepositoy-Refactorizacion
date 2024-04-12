package com.mexiti.catphotoapp.ui.viewmodel

import android.text.Editable.Factory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mexiti.catphotoapp.DogPhotoApplication
import com.mexiti.catphotoapp.data.DogPhotoRepository
import com.mexiti.catphotoapp.data.NetworkDogPhotoRepository
import com.mexiti.catphotoapp.model.DogModel

import kotlinx.coroutines.launch
import java.io.IOException

sealed interface DogUiState{
    data class Success(val photos: List<DogModel>): DogUiState
    object Error:DogUiState
    object Loading: DogUiState
}
class DogViewModel(private val dogPhotoRepository:DogPhotoRepository):ViewModel() {
    var dogUiState:DogUiState by mutableStateOf(DogUiState.Loading)
        private set
    init {
        getDogPhotos()
    }
    private fun getDogPhotos(){
        //corrutina
        viewModelScope.launch {

            dogUiState= try{

                val listResult= dogPhotoRepository.getDogPhotos()
                DogUiState.Success(listResult)

            }catch (e:IOException){
                DogUiState.Error
            }

        }
    }
        companion object {
            val Factory: ViewModelProvider.Factory= viewModelFactory {
                initializer {
                    val application=(this[APPLICATION_KEY] as DogPhotoApplication)
                    val dogPhotoRepository=application.container.dogPhotoRepository
                    DogViewModel(dogPhotoRepository= dogPhotoRepository)
                }
            }
        }


}