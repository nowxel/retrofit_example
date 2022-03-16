package com.example.retrofitexample

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestApiService {
    private var api: TestAPI
    private val secretKey: String = "\$2b\$10\$/nbUpxSofW6UgvmjYVbAbeyh.TNMS8QdmITrxAStZor/cNK7JbqUK"

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(TestAPI::class.java)
    }

    fun getLocalNews(callback: NewsCallback) {
        api.getLocalNews(secretKey).enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response:
            Response<News>
            ) {
                if (response.code() == 200 && response.body() != null)
                    callback.onSuccess(response.body()!!)
                else
                    callback.onFailure()
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                callback.onFailure()
            }
        })
    }

    interface NewsCallback {
        fun onSuccess(news: News)
        fun onFailure()
    }


}