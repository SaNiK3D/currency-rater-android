package com.sanik.currencyrater.utils

import com.sanik.currencyrater.db.entity.CurrencyInfo
import com.sanik.currencyrater.db.entity.CurrencyPair

val currencyInfoTestList = arrayListOf(
    CurrencyInfo("USD", "United State Dollar"),
    CurrencyInfo("EUR", "Euro"),
    CurrencyInfo("RUB", "Ruble")
)

val currencyPairsTest = arrayListOf(
    CurrencyPair(0, 1),
    CurrencyPair(1, 2),
    CurrencyPair(0, 1)
)