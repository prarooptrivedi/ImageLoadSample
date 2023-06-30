package com.transsoultion.api

import com.soultion.sampleimageview.models.Images
import retrofit2.Response
import retrofit2.http.GET

interface ImageListApi {
    @GET("photos/")
    //suspend fun getCustomer():Response<List<CustomerResponse>>
    suspend fun getCustomer():Response<Images>



}