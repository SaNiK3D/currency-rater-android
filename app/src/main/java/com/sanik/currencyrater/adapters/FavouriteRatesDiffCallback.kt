package com.sanik.currencyrater.adapters

import androidx.recyclerview.widget.DiffUtil
import com.sanik.currencyrater.db.data.CurrencyRateWithRateAndDate

class FavouriteRatesDiffCallback : DiffUtil.ItemCallback<CurrencyRateWithRateAndDate>() {
    override fun areItemsTheSame(
        oldItem: CurrencyRateWithRateAndDate,
        newItem: CurrencyRateWithRateAndDate
    ): Boolean {
        return oldItem.rateId == newItem.rateId
    }

    override fun areContentsTheSame(
        oldItem: CurrencyRateWithRateAndDate,
        newItem: CurrencyRateWithRateAndDate
    ): Boolean {
        return oldItem == newItem
    }

}