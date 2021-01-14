package com.example.mycriptoapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mycriptoapp.R
import com.example.mycriptoapp.databinding.ItemCoinInfoBinding
import com.example.mycriptoapp.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {
    private lateinit var binding: ItemCoinInfoBinding
    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onCoinClickListener: OnCoinClickListener? = null

    inner class CoinInfoViewHolder(binding: ItemCoinInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_coin_info, parent, false
        )
        return CoinInfoViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        val symbolsTemplate = context.resources.getString(R.string.symbols_template)
        val lastUpdate = context.resources.getString(R.string.last_update_time)
        binding.coinFromSymbolToSymbol =
            String.format(symbolsTemplate, coin.fromSymbol, coin.toSymbol)
        binding.tvDate.text = String.format(lastUpdate, coin.getFormattedTime())
        binding.tvPrice.text = coin.price.toString()
        Log.d("TEST_OF_LOADING_DATA", coin.price.toString())
        Picasso.get().load(coin.getFullImageUrl()).into(binding.ivLogoCoin)
        holder.itemView.setOnClickListener{
            onCoinClickListener?.onCoinClick(coin)
        }

    }

    override fun getItemCount() = coinInfoList.size

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }

}