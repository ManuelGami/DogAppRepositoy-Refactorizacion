package com.mexiti.catphotoapp.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mexiti.dogphotoapp.network.DogApi

import kotlinx.coroutines.launch
import java.io.IOException

sealed interface DogUiState{
    data class Success(val photos:String): DogUiState
    object Error:DogUiState
    object Loading: DogUiState
}
class DogViewModel:ViewModel() {
    var dogUiState:DogUiState by mutableStateOf(DogUiState.Loading)
        private set
    init {
        getDogPhotos()
    }
    fun getDogPhotos(){
        //corrutina
        viewModelScope.launch {

            dogUiState= try{
                val listResult= DogApi.retrofitService.getPhotos()
                DogUiState.Success("Numero perros recibidos es: ${listResult.size}")

            }catch (e:IOException){
                DogUiState.Error
            }

        }
    }

}