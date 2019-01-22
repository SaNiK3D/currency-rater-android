package com.sanik.currencyrater.utilities

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanik.currencyrater.db.AppDatabase
import com.sanik.currencyrater.network.CurrencyRaterNetwork
import com.sanik.currencyrater.network.api.FavouritesApi
import com.sanik.currencyrater.repository.CurrencyInfoRepository
import com.sanik.currencyrater.repository.FavouriteRatesRepository
import com.sanik.currencyrater.viewmodels.AddFavouriteViewModel
import com.sanik.currencyrater.viewmodels.FavouriteRatesViewModel

object InjectorUtil {
    fun provideFavouritesViewModelFactory(context: Context) : ViewModelProvider.Factory{
        val repository = getFavouriteRatesRepository(context)

        return object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return FavouriteRatesViewModel(repository) as T
            }
        }
    }

    private fun getFavouriteRatesRepository(context: Context) : FavouriteRatesRepository {
        return FavouriteRatesRepository.getInstance(
                AppDatabase.getInstance(context).getFavouritesDao(),
                CurrencyRaterNetwork.getInstance().favouritesApi
        )
    }

    fun provideAddFavouriteViewModelFactory(context: Context): ViewModelProvider.Factory {
        val repository = getCurrencyInfoRepository(context)

        return object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return AddFavouriteViewModel(repository) as T
            }
        }
    }

    private fun getCurrencyInfoRepository(context: Context) : CurrencyInfoRepository {
        return CurrencyInfoRepository.getInstance(
                AppDatabase.getInstance(context).getCurrencyInfoDao()
        )
    }
}