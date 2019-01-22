package com.sanik.currencyrater.viewmodels

import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.sanik.currencyrater.R
import com.sanik.currencyrater.db.data.CurrencyRateChange

class CurrencyRateChangeViewModel(
        context: Context,
        currencyRateChange: CurrencyRateChange
) : ViewModel() {
    val rate = ObservableField<String>(
        context.getString(R.string.rate_format).format(currencyRateChange.rate)
    )

    val change = ObservableField<String>(
        context.getString(R.string.change_format).format(currencyRateChange.change)
    )

    val currencies = ObservableField<String>(
        currencyRateChange.baseCode + " - " + currencyRateChange.targetCode
    )

    val isChangePositive = ObservableBoolean(currencyRateChange.change >= 0)
}