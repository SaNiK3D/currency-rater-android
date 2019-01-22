package com.sanik.currencyrater.adapters

import androidx.recyclerview.widget.DiffUtil
import com.sanik.currencyrater.db.data.CurrencyRateChange
import com.sanik.currencyrater.db.data.CurrencyRateWithDate

class FavouriteRatesDiffCallback : DiffUtil.ItemCallback<CurrencyRateChange>() {
    override fun areItemsTheSame(
        oldItem: CurrencyRateChange,
        newItem: CurrencyRateChange
    ): Boolean {
        return oldItem.rateId == newItem.rateId
    }

    override fun areContentsTheSame(
        oldItem: CurrencyRateChange,
        newItem: CurrencyRateChange
    ): Boolean {
        return oldItem == newItem
    }

}