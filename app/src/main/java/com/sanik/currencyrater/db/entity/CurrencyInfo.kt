package com.sanik.currencyrater.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "currency_info")
data class CurrencyInfo (
    val code: String,

    @ColumnInfo(name = "full_name")
    val fullName: String
) {
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "currency_id")
    var currencyId: Int = 0
}