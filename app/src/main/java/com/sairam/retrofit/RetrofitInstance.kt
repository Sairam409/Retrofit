package com.sairam.retrofit

import com.sairam.retrofit.data.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//iniializing instance of retrofit for api
object RetrofitInstance {
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val  client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
    //creating api instance & upper code is reusable
    val api: Api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create()) // converts json to data class
        .baseUrl(Api.BASE_URL)
        .client(client)
        .build()
        .create(Api::class.java)

}