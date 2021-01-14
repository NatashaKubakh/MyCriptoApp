package com.example.mycriptoapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.mycriptoapp.api.ApiFactory
import com.example.mycriptoapp.database.AppDatabase
import com.example.mycriptoapp.pojo.CoinPriceInfo
import com.example.mycriptoapp.pojo.CoinPriceInfoRawData
import com.google.gson.Gson
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CoinViewModel(application: Application) : AndroidViewModel(application) {


    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()
    val priceList = db.coinPriceInfoDao().getPriceList()

    fun loadData() {
        val disposable = ApiFactory.apiService.getTopCoinsInfo(limit = 20)
            .map { it -> it.data?.map { it.coinInfo?.name }?.joinToString(",") }
            .flatMap { it?.let { ApiFactory.apiService.getFullPriceList(fSyms = it) } }
            .map { getPriceListFromRawData(it) }
            .subscribeOn(Schedulers.io())
            .subscribe({
                it?.let {
                    Log.d("TEST_OF_LOADING_DATA", it.toString())
                    db.coinPriceInfoDao().insertPriceList(it)
                }
            }, {
                it.message?.let { it1 -> Log.d("TEST_OF_LOADING_DATA", it1) }
            })
        compositeDisposable.add(disposable)
    }

    private fun getPriceListFromRawData(coinPriceInfoRawData: CoinPriceInfoRawData): List<CoinPriceInfo>? {
        val result = ArrayList<CoinPriceInfo>()
        val jsonObject = coinPriceInfoRawData.coinPriceInfoJsonObject ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinPriceInfo::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}