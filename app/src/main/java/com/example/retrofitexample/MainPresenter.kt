package com.example.retrofitexample

import android.util.Log

class MainPresenter : MainContract.Presenter {
    private var view: MainContract.View? = null

    private val dataSource: IDataSource = DiHelper.provideIDataSource()

    override fun loadData() {
        Log.d("API", "loadData")
        dataSource.getLocalNews(
            onResult = {
                view?.displayNews(it)
            },
            onError = {
                view?.displayError(it)
            },
        )
    }

    override fun registerView(view: MainContract.View) {
        this.view = view
    }

    override fun unregisterView(view: MainContract.View) {
        this.view = null
    }
}