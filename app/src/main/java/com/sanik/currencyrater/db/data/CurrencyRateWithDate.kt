package com.sanik.currencyrater.db.data

import java.util.*
import androidx.room.Ignore

data class CurrencyRateWithDate (
    val rateId: Int,
    val pairId: Int,
    val baseCode: String,
    val targetCode: String,
    val rate: Double,
    val date: Calendar
) {
    @Ignore var change: Double = 0.0
}