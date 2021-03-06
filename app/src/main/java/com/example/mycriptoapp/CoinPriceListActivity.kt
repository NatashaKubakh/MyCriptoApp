package com.example.mycriptoapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mycriptoapp.adapters.CoinInfoAdapter
import com.example.mycriptoapp.databinding.ActivityCoinPriceListBinding
import com.example.mycriptoapp.pojo.CoinPriceInfo
import com.example.mycriptoapp.viewModels.CoinViewModel


class CoinPriceListActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityCoinPriceListBinding
    private lateinit var adapter: CoinInfoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coin_price_list)
        adapter = CoinInfoAdapter(this)
        binding.rvCoinPriceList.adapter = adapter
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(
                    this@CoinPriceListActivity,
                    coinPriceInfo.fromSymbol
                )
                startActivity(intent)
            }
        }
        viewModel = ViewModelProvider.AndroidViewModelFactory(this.application)
            .create(CoinViewModel::class.java)
        viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList = it
        })

    }
}