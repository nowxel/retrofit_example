package com.example.retrofitexample

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestApiService : IDataSource {
    private val secretKey: String =
        "\$2b\$10\$/nbUpxSofW6UgvmjYVbAbeyh.TNMS8QdmITrxAStZor/cNK7JbqUK"

    private val api: TestAPI = DiHelper.provideTestApi()

    override fun getLocalNews(
        onResult: (News) -> Unit,
        onError: (Throwable) -> Unit,
    ) {
        api.getLocalNews(secretKey).enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val body = response.body()
                if (response.code() == 200 && body != null)
                    onResult(body)
                else
                    onError(Exception("Bad response"))
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                onError(t)
            }
        })
    }
}