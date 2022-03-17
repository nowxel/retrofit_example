package com.example.retrofitexample

interface IDataSource {
    fun getLocalNews(
        onResult: (News) -> Unit,
        onError: (Throwable) -> Unit,
    )
}