package com.example.mycriptoapp


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider.AndroidViewModelFactory(this.application).create(CoinViewModel::class.java)
        viewModel.loadData()
        viewModel.priceList.observe(this, Observer {
            Log.d("TEST_OF_LOADING_DATA", "success in activity $it")
        })
    }

    }


