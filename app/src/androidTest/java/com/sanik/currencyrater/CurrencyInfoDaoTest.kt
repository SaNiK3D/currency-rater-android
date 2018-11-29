package com.sanik.currencyrater

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry

import com.sanik.currencyrater.db.AppDatabase
import com.sanik.currencyrater.db.dao.CurrencyInfoDao
import com.sanik.currencyrater.utils.currencyInfoTestList
import com.sanik.currencyrater.utils.getValue

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class CurrencyInfoDaoTest {
    private lateinit var currencyInfoDao: CurrencyInfoDao
    private lateinit var appDatabase: AppDatabase

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        appDatabase = Room
            .inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .build()
        currencyInfoDao = appDatabase.getCurrencyInfoDao()

        currencyInfoDao.insertCurrencyInfo(currencyInfoTestList)
    }

    @After
    fun closeDb() {
        appDatabase.close()
    }

    @Test
    fun test_getAllCurrencyInfo(){
        val currencyInfos = getValue(currencyInfoDao.getAllCurrencyInfo())

        assertEquals(currencyInfos, currencyInfoTestList)
    }
}