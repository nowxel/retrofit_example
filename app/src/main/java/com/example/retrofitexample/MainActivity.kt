package com.example.retrofitexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofitexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var bindingClass: ActivityMainBinding
    private val presenter = DiHelper.provideMainPresenter()

    @SuppressLint
    override fun displayNews(news: News) {
        Log.d("API", news.author)
        Log.d("API", news.source.name)
        bindingClass.author.text = "Author: ${news.author}"
        bindingClass.date.text = "Author: ${news.source.name}"
    }

    override fun displayError(throwable: Throwable) {
        throwable.printStackTrace()
        Toast.makeText(
            this, throwable.message,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        presenter.registerView(this)

        bindingClass.button.setOnClickListener { presenter.loadData() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unregisterView(this)
    }
}