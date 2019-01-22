package com.sanik.currencyrater.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sanik.currencyrater.repository.CurrencyInfoRepository

class AddFavouriteViewModel(
        repository: CurrencyInfoRepository
) : ViewModel() {
    fun getNamePositionByCode(code: String): Int {
        val name = currencyInfoList.value?.find { currencyInfo -> currencyInfo.code == code }?.fullName
        return currencyInfoNameList.value?.indexOf(name) ?: -1
    }

    fun getCodePositionByName(name: String): Int {
        val code = currencyInfoList.value?.find { currencyInfo -> currencyInfo.fullName == name }?.code
        return currencyInfoCodeList.value?.indexOf(code) ?: -1
    }

    private val currencyInfoList = repository.currencyInfoList

    val currencyInfoCodeList: LiveData<List<String>> = Transformations.map(currencyInfoList) { currencyInfoList -> currencyInfoList.map { it.code }.sorted() }
    val currencyInfoNameList: LiveData<List<String>> = Transformations.map(currencyInfoList) { currencyInfoList -> currencyInfoList.map { it.fullName }.sorted() }
}
