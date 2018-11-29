package com.sanik.currencyrater.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sanik.currencyrater.db.entity.CurrencyInfo

@Dao
interface CurrencyInfoDao {
    @Insert
    fun insertCurrencyInfo(currencyInfoList: List<CurrencyInfo>)

    @Query("SELECT * FROM currency_info")
    fun getAllCurrencyInfo() : LiveData<List<CurrencyInfo>>
}