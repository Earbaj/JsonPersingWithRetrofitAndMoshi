package com.example.openapiperse.network

import com.example.openapiperse.data.JsonData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://jsonplaceholder.typicode.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RestApiServiceCall {
    @GET("photos")
    suspend fun getAllData(): List<JsonData>
}

object JsonApi {
    val retrofitService : RestApiServiceCall by lazy {
        retrofit.create(RestApiServiceCall::class.java)
    }
}

