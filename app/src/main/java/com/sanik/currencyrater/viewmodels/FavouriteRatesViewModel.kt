package com.sanik.currencyrater.viewmodels


import androidx.lifecycle.ViewModel
import com.sanik.currencyrater.repository.FavouriteRatesRepository


class FavouriteRatesViewModel internal constructor(
        repository: FavouriteRatesRepository
) : ViewModel() {
    val favouriteRates = repository.getFavouriteRatesForToday()

}
