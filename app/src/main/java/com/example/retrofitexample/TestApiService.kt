package com.example.retrofitexample

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class TestApiService {
    private val secretKey: String = "\$2b\$10\$/nbUpxSofW6UgvmjYVbAbeyh.TNMS8QdmITrxAStZor/cNK7JbqUK"

    private val retrofit: Retrofit = RetrofitApiHelper.getRetrofitInstance()
    private val api: TestAPI = retrofit.create(TestAPI::class.java)

    fun getLocalNews(callback: NewsCallback) {
        api.getLocalNews(secretKey).enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
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