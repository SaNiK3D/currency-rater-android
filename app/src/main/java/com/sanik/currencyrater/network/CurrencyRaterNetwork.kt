package com.sanik.currencyrater.network

import com.sanik.currencyrater.network.api.FavouritesApi

class CurrencyRaterNetwork {
    lateinit var favouritesApi: FavouritesApi

    companion object {
        @Volatile private var instance: CurrencyRaterNetwork? = null

        fun getInstance() : CurrencyRaterNetwork{
            return instance?: synchronized(this){
                instance ?: initNetwork().also { instance = it}
            }
        }

        private fun initNetwork(): CurrencyRaterNetwork {
            return  CurrencyRaterNetwork().apply { favouritesApi = object : FavouritesApi {
                // mock object
            } }
            // todo: init retrofit client
        }
    }
}