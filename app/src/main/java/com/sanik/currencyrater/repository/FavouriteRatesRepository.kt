package com.sanik.currencyrater.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sanik.currencyrater.db.dao.FavouritesDao
import com.sanik.currencyrater.db.data.CurrencyRateChange
import com.sanik.currencyrater.network.api.FavouritesApi

open class FavouriteRatesRepository internal constructor(
    private val favouritesDao: FavouritesDao,
    private val favouritesApi: FavouritesApi
) {

    private val favouriteRates: MutableLiveData<List<CurrencyRateChange>> by lazy {
        val fakeList = arrayListOf(
                CurrencyRateChange(0, "USD", "RUB", 30.002, 0.05),
                CurrencyRateChange(1, "USE", "AMD", 10.002, -10.05),
                CurrencyRateChange(2, "FRA", "GUB", 0.7, 0.001)
                )

        return@lazy MutableLiveData<List<CurrencyRateChange>>().apply { value = fakeList }
    }
    open fun getFavouriteRatesForToday(): LiveData<List<CurrencyRateChange>> {
        return favouriteRates
        //return favouritesDao.getFavouriteRatesOnDates(today(), yesterday())
    }

    companion object {
        @Volatile private var instance: FavouriteRatesRepository? = null

        fun getInstance(favouritesDao: FavouritesDao, favouritesApi: FavouritesApi) =
                instance ?: synchronized(this) {
                    instance ?: FavouriteRatesRepository(favouritesDao, favouritesApi).also { instance = it }
                }
    }
}