package com.sanik.currencyrater.viewmodels

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.sanik.currencyrater.R
import com.sanik.currencyrater.db.data.CurrencyRateWithRateAndDate

class CurrencyRateWithRateAndDateViewModel(
    private val context: Context,
    private val currencyRateWithRateAndDate: CurrencyRateWithRateAndDate
) : ViewModel() {
    val rate = ObservableField<String>(
        context.getString(R.string.rate_format).format(currencyRateWithRateAndDate.rate)
    )

    val change = ObservableField<String>(
        context.getString(R.string.rate_format).format(currencyRateWithRateAndDate.rate)
    )

    val currencies = ObservableField<String>(

    )

}