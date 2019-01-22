package com.sanik.currencyrater.repository

import androidx.lifecycle.MutableLiveData
import com.sanik.currencyrater.db.dao.CurrencyInfoDao
import com.sanik.currencyrater.db.entity.CurrencyInfo

class CurrencyInfoRepository internal constructor(
        private val currencyInfoDao: CurrencyInfoDao
){

    companion object {
        @Volatile private var instance: CurrencyInfoRepository? = null

        fun getInstance(currencyInfoDao: CurrencyInfoDao) =
                instance ?: synchronized(this) {
                    instance ?: CurrencyInfoRepository(currencyInfoDao).also { instance = it }
                }
    }

    val currencyInfoList: MutableLiveData<List<CurrencyInfo>> by lazy {
        val list = arrayListOf(
                CurrencyInfo("RUB", "Rubles"),
                CurrencyInfo("USD", "Dollars"),
                CurrencyInfo("AMD", "Processors")
        )

        return@lazy MutableLiveData<List<CurrencyInfo>>().apply { value = list }
    }

}