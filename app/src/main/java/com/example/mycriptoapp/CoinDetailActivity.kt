package com.example.mycriptoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mycriptoapp.databinding.ActivityCoinDetailBinding
import com.example.mycriptoapp.viewModels.CoinViewModel
import com.squareup.picasso.Picasso

class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityCoinDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coin_detail)
        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL)
        viewModel = ViewModelProvider.AndroidViewModelFactory(this.application)
            .create(CoinViewModel::class.java)
        fromSymbol?.let { it ->
            viewModel.getDetailInfo(it).observe(this, Observer {
                with(binding) {
                    price = it.price.toString()
                    minDay = it.lowDay.toString()
                    maxDay = it.highDay.toString()
                    lastDeal = it.lastMarket
                    lastUpdate = it.getFormattedTime()
                    fSymbol = it.fromSymbol
                    toSymbol = it.toSymbol
                    Picasso.get().load(it.getFullImageUrl()).into(ivLogoCoin)
                }
            })
        }

    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}