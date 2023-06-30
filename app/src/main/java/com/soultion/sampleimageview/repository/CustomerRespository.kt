package com.transsoultion.repository

import androidx.lifecycle.MutableLiveData
import com.soultion.sampleimageview.models.Images
import com.transsoultion.api.ImageListApi
import com.transsoultion.utils.NetWorkResult
import org.json.JSONObject
import javax.inject.Inject

class CustomerRespository @Inject constructor(private val customerListApi: ImageListApi) {
    private val _customerliveData = MutableLiveData<NetWorkResult<Images>>()
    val customerLiveData get() = _customerliveData

    private val _statusLiveData = MutableLiveData<NetWorkResult<Pair<Boolean, String>>>()
    val statusLiveData get() = _statusLiveData
    suspend fun getCustomer(){

        _customerliveData.postValue(NetWorkResult.Loading())
        try {
            val response=customerListApi.getCustomer()
            if (response.isSuccessful && response.body() != null) {
                _customerliveData.postValue(NetWorkResult.Sucess(response.body()!!))
            }
            else if (response.errorBody() != null) {
                var errorObject = JSONObject(response.errorBody()!!.charStream().readText())
                _customerliveData.postValue(NetWorkResult.Error(errorObject.getString("message")))
            } else {
                _customerliveData.postValue(NetWorkResult.Error("Something went Wrong"))
            }
        }
        catch (e:Exception){
            e.printStackTrace()
        }



    }



}