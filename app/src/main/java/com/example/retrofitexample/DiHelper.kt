package com.example.retrofitexample

object DiHelper {
    fun provideTestApi(): TestAPI =
        RetrofitApiHelper.getRetrofitInstance().create(TestAPI::class.java)

    fun provideIDataSource(): IDataSource = TestApiService(provideMainPresenter())

    private var presenter: MainContract.Presenter? = null

    fun provideMainPresenter(): MainContract.Presenter {
        val presenter = this.presenter ?: MainPresenter()
        this.presenter = presenter
        return presenter
    }

}