package com.sanik.currencyrater.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.sanik.currencyrater.db.data.CurrencyPairWithInfo
import com.sanik.currencyrater.db.entity.CurrencyPair

interface CurrencyPairDao {
    @Insert
    fun insertCurrencyPairs(currencyPairs: List<CurrencyPair>)

    @Transaction
    @Query("SELECT * FROM currency_pairs")
    fun getAllCurrencyPairs() : LiveData<List<CurrencyPairWithInfo>>
}