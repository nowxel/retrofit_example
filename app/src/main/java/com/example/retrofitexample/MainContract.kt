package com.example.retrofitexample

interface MainContract {
    interface View {
        fun displayNews(news: News)
        fun displayError(throwable: Throwable)
    }

    interface Presenter {
        fun loadData()
        fun registerView(view: View)
        fun unregisterView(view: View)
    }
}