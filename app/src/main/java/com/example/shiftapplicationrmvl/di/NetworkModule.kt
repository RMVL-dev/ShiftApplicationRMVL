package com.example.shiftapplicationrmvl.di

import com.example.shiftapplicationrmvl.service.RandomUserService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    companion object{
        const val BASE_URL = "https://randomuser.me/api/"
    }

    @Provides
    fun provideOkHttp() =
        OkHttpClient.Builder().apply {

        }
            .connectTimeout(20000L, TimeUnit.MILLISECONDS)
            .readTimeout(20000L, TimeUnit.MILLISECONDS)
            .writeTimeout(20000L, TimeUnit.MILLISECONDS)
            .build()

    @Provides
    fun provideRetrofit(
        okHttpClient:OkHttpClient,
        gson: Gson
    ): Retrofit? = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    @Provides
    fun provideGson():Gson =GsonBuilder().create()

    @Provides
    fun provideRandomUserService(retrofit: Retrofit): RandomUserService =
        retrofit.create(RandomUserService::class.java)
}