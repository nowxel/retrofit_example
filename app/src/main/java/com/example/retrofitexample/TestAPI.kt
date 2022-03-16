package com.example.retrofitexample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface TestAPI {
    @GET("b/622f014f7caf5d6783686edd")
    fun getLocalNews(@Header("secret-key") secretKey: String): Call<News>
}