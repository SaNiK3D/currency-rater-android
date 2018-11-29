package com.sanik.currencyrater.db.entity

import androidx.room.*
import java.util.Calendar

@Entity(
    tableName = "currency_rates",
    foreignKeys = [ForeignKey(
        entity = CurrencyPair::class,
        parentColumns = ["pair_id"],
        childColumns = ["rate_id"])
    ],
    indices = [Index("rate_id")] )
data class CurrencyRate(
    val rate: Double,
    val date: Calendar
) {
    @PrimaryKey
    @ColumnInfo(name = "rate_id")
    var rateId: Int = 0
}