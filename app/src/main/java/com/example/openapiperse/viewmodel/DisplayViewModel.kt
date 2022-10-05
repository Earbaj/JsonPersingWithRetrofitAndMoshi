package com.example.openapiperse.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openapiperse.data.JsonData
import com.example.openapiperse.network.JsonApi
import kotlinx.coroutines.launch

class DisplayViewModel: ViewModel(){

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _photo = MutableLiveData<List<JsonData>>()
    val photo: LiveData<List<JsonData>> = _photo

    init {
        getAllData()
    }

    fun getAllData(){
        _status.value = "Perse Json Data From Api"
        viewModelScope.launch {
            try {
                _photo.value = JsonApi.retrofitService.getAllData()
            }catch (ex: Exception){
                _photo.value = listOf()
            }
        }
    }
}