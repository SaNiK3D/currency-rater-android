package com.sanik.currencyrater.db.entity

import androidx.room.*

@Entity(
    tableName = "currency_pairs",
    foreignKeys = [
        ForeignKey(
            entity = CurrencyInfo::class,
            parentColumns = ["currency_id"],
            childColumns = ["base_id"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(
            entity = CurrencyInfo::class,
            parentColumns = ["currency_id"],
            childColumns = ["target_id"],
            onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index("base_id"), Index("target_id")]
)
data class CurrencyPair(
    @ColumnInfo(name = "base_id") val baseId: Int,
    @ColumnInfo(name = "target_id") val targetId: Int
) {
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "pair_id") var pairId = 0
}