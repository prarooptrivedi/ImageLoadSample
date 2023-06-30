package com.transsoultion.di

import com.transsoultion.api.AuthInterceptor
import com.transsoultion.api.ImageListApi
import com.transsoultion.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitBUilder():Retrofit.Builder{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)

    }
//    fun provideAuthRetrofit(okHttpClient: OkHttpClient):Retrofit{
//        return Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//            .baseUrl(BASE_URL)
//            .build()
//    }
    @Singleton
    @Provides
    fun provideOkHttpClient (authInterceptor: AuthInterceptor):OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(authInterceptor).build()

    }

    @Singleton
    @Provides
    fun provideCustomerApi(retrofitBuilder: Retrofit.Builder,okHttpClient: OkHttpClient):ImageListApi{
    return retrofitBuilder
        .client(okHttpClient)
        .build().create(ImageListApi::class.java)
    }
}