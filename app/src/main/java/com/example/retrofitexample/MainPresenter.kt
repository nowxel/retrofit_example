package com.example.retrofitexample

import android.util.Log

class MainPresenter(
    private val view: MainContract.View,
) : MainContract.Presenter {

    private val dataSource: IDataSource = TestApiService(this)

    override fun loadData() {
        Log.d("API", "loadData")
        dataSource.getLocalNews()
    }

    override fun onNewsReceived(news: News) {
        view.displayNews(news)
    }

    override fun onError() {
        view.displayError()
    }
}