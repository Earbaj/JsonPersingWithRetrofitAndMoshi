package com.example.openapiperse.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DisplayViewModel: ViewModel(){

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    init {
        getAllData()
    }

    fun getAllData(){
        _status.value = "Perse Json Data From Api"
    }
}