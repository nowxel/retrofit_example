package com.example.retrofitexample

object DiHelper {
    fun provideTestApi(): TestAPI =
        RetrofitApiHelper.getRetrofitInstance().create(TestAPI::class.java)

    fun provideIDataSource(): IDataSource = TestApiService()

    fun provideMainPresenter(): MainContract.Presenter = MainPresenter()

}