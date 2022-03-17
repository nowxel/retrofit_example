package com.example.retrofitexample

import android.util.Log

class MainPresenter(private val view: MainContract.View): MainContract.Presenter {
    override fun loadData() {
        Log.d("API", "loadData")
        val service = TestApiService()
        service.getLocalNews(object : TestApiService.NewsCallback {
            override fun onSuccess(news: News) {
                view.displayNews(news)
            }
            override fun onFailure() {
                view.displayError()
            }
        })
    }
}