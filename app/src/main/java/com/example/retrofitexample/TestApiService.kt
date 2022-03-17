package com.example.retrofitexample

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestApiService(
    private val presenter: MainContract.Presenter
) : IDataSource {
    private val secretKey: String =
        "\$2b\$10\$/nbUpxSofW6UgvmjYVbAbeyh.TNMS8QdmITrxAStZor/cNK7JbqUK"

    private val api: TestAPI = DiHelper.provideTestApi()

    override fun getLocalNews() {
        api.getLocalNews(secretKey).enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                if (response.code() == 200 && response.body() != null)
                    presenter.onNewsReceived(response.body()!!)
                else
                    presenter.onError()
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                presenter.onError()
            }
        })
    }
}