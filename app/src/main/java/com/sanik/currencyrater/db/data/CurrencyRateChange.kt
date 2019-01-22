package com.sanik.currencyrater.db.data

data class CurrencyRateChange(
        val rateId: Int,
        val baseCode: String,
        val targetCode: String,
        val rate: Double,
        val change: Double
)