package com.example.mycriptoapp.pojo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String?,
    @SerializedName("MARKET")
    @Expose
    val market: String?,
    @NonNull
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,
    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String?,
    @SerializedName("FLAGS")
    @Expose
    val flags: String?,
    @SerializedName("PRICE")
    @Expose
    val price: Double?,
    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Int?,
    @SerializedName("MEDIAN")
    @Expose
    val median: Double?,
    @SerializedName("LASTVOLUME")
    @Expose
    val lastVolume: Double?,
    @SerializedName("LASTVOLUMETO")
    @Expose
    val lastVolumeTo: Double?,
    @SerializedName("LASTTRADEID")
    @Expose
    val lastTradeId: String?,
    @SerializedName("VOLUMEDAY")
    @Expose
    val volumeDay: Double?,
    @SerializedName("VOLUMEDAYTO")
    @Expose
    val volumeDayTo: Double?,
    @SerializedName("VOLUME24HOUR")
    @Expose
    val volume24Hour: Double?,
    @SerializedName("VOLUME24HOURTO")
    @Expose
    val volume24HourTo: Double?,
    @SerializedName("OPENDAY")
    @Expose
    val openDay: Double?,
    @SerializedName("HIGHDAY")
    @Expose
    val highDay: Double?,
    @SerializedName("LOWDAY")
    @Expose
    val lowDay: Double?,
    @SerializedName("OPEN24HOUR")
    @Expose
    val open24Hour: Double?,
    @SerializedName("HIGH24HOUR")
    @Expose
    val high24Hour: Double?,
    @SerializedName("LOW24HOUR")
    @Expose
    val low24Hour: Double?,
    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String?,
    @SerializedName("VOLUMEHOUR")
    @Expose
    val volumeHour: Double?,
    @SerializedName("VOLUMEHOURTO")
    @Expose
    val volumeHourTo: Double?,
    @SerializedName("OPENHOUR")
    @Expose
    val openHour: Double?,
    @SerializedName("HIGHHOUR")
    @Expose
    val highHour: Double?,
    @SerializedName("LOWHOUR")
    @Expose
    val lowHour: Double?,
    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    val topTierVolume24Hour: Double?,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    val topTierVolume24HourTo: Double?,
    @SerializedName("CHANGE24HOUR")
    @Expose
    val change24Hour: Double?,
    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    val changePCT24Hour: Double?,
    @SerializedName("CHANGEDAY")
    @Expose
    val changeDay: Double?,
    @SerializedName("CHANGEPCTDAY")
    @Expose
    val changePCTDay: Double?,
    @SerializedName("CHANGEHOUR")
    @Expose
    val changeHour: Double?,
    @SerializedName("CHANGEPCTHOUR")
    @Expose
    val changePCTHour: Double?,
    @SerializedName("CONVERSIONTYPE")
    @Expose
    val conversionType: String?,
    @SerializedName("CONVERSIONSYMBOL")
    @Expose
    val conversionSymbol: String?,
    @SerializedName("SUPPLY")
    @Expose
    val supply: Int?,
    @SerializedName("MKTCAP")
    @Expose
    val mktCap: Int?,
    @SerializedName("MKTCAPPENALTY")
    @Expose
    val mktCapPenalty: Int?,
    @SerializedName("TOTALVOLUME24H")
    @Expose
    val totalVolume24H: Double?,
    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    val totalVolume24HTo: Double?,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    @Expose
    val totalTopTierVolume24H: Double?,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    @Expose
    val totalTopTierVolume24HTo: Double?,
    @SerializedName("IMAGEURL")
    @Expose
    val imageURL: String?,
)
