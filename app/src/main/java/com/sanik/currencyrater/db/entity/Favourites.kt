package com.sanik.currencyrater.db.entity

import androidx.room.*

@Entity(
    tableName = "favourites",
    foreignKeys = [
        ForeignKey(
            entity = CurrencyPair::class,
            parentColumns = ["pair_id"],
            childColumns = ["fav_id"],
            onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index("fav_id")]
)
data class Favourites(
    @PrimaryKey
    @ColumnInfo(name = "fav_id")
    var favouritePairId: Int
)