package com.example.retrofitexample

import android.util.Log

class MainPresenter : MainContract.Presenter {
    private var view: MainContract.View? = null

    private val dataSource: IDataSource by lazy { DiHelper.provideIDataSource() }

    override fun loadData() {
        Log.d("API", "loadData")
        dataSource.getLocalNews()
    }

    override fun onNewsReceived(news: News) {
        view?.displayNews(news)
    }

    override fun onError() {
        view?.displayError()
    }

    override fun registerView(view: MainContract.View) {
        this.view = view
    }

    override fun unregisterView(view: MainContract.View) {
        this.view = null
    }
}