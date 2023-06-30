package com.transsoultion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.transsoultion.repository.CustomerRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val customerRespository: CustomerRespository) : ViewModel() {
    val customerliveData get() = customerRespository.customerLiveData

    fun getCustomer(){
        try {
            viewModelScope.launch {
                customerRespository.getCustomer()
            }
        }
        catch (e:Exception){

        }


    }
}