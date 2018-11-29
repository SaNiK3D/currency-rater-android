package com.sanik.currencyrater.db.data

import java.util.*

data class CurrencyRateWithRateAndDate (
    val rateId: Int,
    val baseCode: String,
    val targetCode: String,
    val rate: Double,
    val date: Calendar
)