package com.sanik.currencyrater.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.sanik.currencyrater.db.data.CurrencyRateWithRateAndDate
import java.util.*

@Dao
interface FavouritesDao {
    @Query("SELECT rate_id as rateId, b_info.code as baseCode, t_info.code as targetCode, rate, date FROM favourites INNER JOIN currency_pairs ON fav_id = pair_id " +
            "INNER JOIN currency_info b_info ON base_id = b_info.currency_id " +
            "INNER JOIN currency_info t_info ON base_id = t_info.currency_id " +
            "INNER JOIN currency_rates ON pair_id = rate_id WHERE date BETWEEN :startDate AND :endDate")
    fun getRatesBetweenDates(startDate: Calendar, endDate: Calendar): LiveData<List<CurrencyRateWithRateAndDate>>

}