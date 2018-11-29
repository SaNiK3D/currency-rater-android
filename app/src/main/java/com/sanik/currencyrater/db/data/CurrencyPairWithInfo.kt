package com.sanik.currencyrater.db.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.sanik.currencyrater.db.entity.CurrencyInfo

class CurrencyPairWithInfo (
    @Embedded val baseCurrency: CurrencyInfo,
    @Embedded val targetCurrency: CurrencyInfo,
    @ColumnInfo(name = "pair_id") val pairId: Int
)