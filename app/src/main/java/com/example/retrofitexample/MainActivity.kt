package com.example.retrofitexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofitexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding

    @SuppressLint
    fun displayNews(news: News) {
        Log.d("API", "${news.author}")
        Log.d("API", "${news.source.name}")
        bindingClass.author.text = "Author: ${news.author}"
        bindingClass.date.text = "Author: ${news.source.name}"
    }
    private fun displayError() {
        Log.d("API", "error loading data")
        Toast.makeText(MainActivity@ this, "error",
            Toast.LENGTH_LONG).show()
    }

    private fun loadData() {
        Log.d("API", "loadData")
        val service = TestApiService()
        service.getLocalNews(object : TestApiService.NewsCallback {
            override fun onSuccess(news: News) {
                displayNews(news)
            }
            override fun onFailure() {
                displayError()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.button.setOnClickListener{ loadData()}
    }
}