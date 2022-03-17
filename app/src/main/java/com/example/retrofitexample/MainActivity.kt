package com.example.retrofitexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofitexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var bindingClass: ActivityMainBinding
    private val presenter = MainPresenter(this)

    @SuppressLint
    override fun displayNews(news: News) {
        Log.d("API", news.author)
        Log.d("API", news.source.name)
        bindingClass.author.text = "Author: ${news.author}"
        bindingClass.date.text = "Author: ${news.source.name}"
    }

    override fun displayError() {
        Log.d("API", "error loading data")
        Toast.makeText(
            this, "error",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.button.setOnClickListener { presenter.loadData() }
    }
}