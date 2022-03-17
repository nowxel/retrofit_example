package com.example.retrofitexample

interface MainContract {
    interface View {
        fun displayNews(news: News)
        fun displayError()
    }

    interface Presenter {
        fun loadData()
        fun onNewsReceived(news: News)
        fun onError()
    }
}