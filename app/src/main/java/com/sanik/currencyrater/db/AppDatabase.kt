package com.sanik.currencyrater.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sanik.currencyrater.db.converters.Converters
import com.sanik.currencyrater.db.dao.CurrencyInfoDao
import com.sanik.currencyrater.db.dao.FavouritesDao
import com.sanik.currencyrater.db.entity.CurrencyInfo
import com.sanik.currencyrater.db.entity.CurrencyPair
import com.sanik.currencyrater.db.entity.CurrencyRate
import com.sanik.currencyrater.db.entity.Favourites
import com.sanik.currencyrater.utilities.DATABASE_NAME

@Database(entities = [CurrencyInfo::class, CurrencyPair::class, CurrencyRate::class, Favourites::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getFavouritesDao(): FavouritesDao
    abstract fun getCurrencyInfoDao(): CurrencyInfoDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).
                addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // todo: use WorkManager to get list of currencies from https://www.currencyconverterapi.com and insert them in DB
                    }
                })
                .build()
        }
    }
}