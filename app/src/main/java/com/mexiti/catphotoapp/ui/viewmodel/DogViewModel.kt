package com.mexiti.catphotoapp.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mexiti.catphotoapp.model.DogModel
import com.mexiti.catphotoapp.network.DogApi

import kotlinx.coroutines.launch
import java.io.IOException

sealed interface DogUiState{
    data class Success(val photos: List<DogModel>): DogUiState
    object Error:DogUiState
    object Loading: DogUiState
}
class DogViewModel:ViewModel() {
    var dogUiState:DogUiState by mutableStateOf(DogUiState.Loading)
        private set
    init {
        getDogPhotos()
    }
    private fun getDogPhotos(){
        //corrutina
        viewModelScope.launch {

            dogUiState= try{
                val listResult1= DogApi.retrofitService.getPhotos()
                val listResult2= DogApi.retrofitService.getPhotos()
                val listResult=listResult1.plus(listResult2)
                DogUiState.Success(listResult)

            }catch (e:IOException){
                DogUiState.Error
            }

        }
    }

}