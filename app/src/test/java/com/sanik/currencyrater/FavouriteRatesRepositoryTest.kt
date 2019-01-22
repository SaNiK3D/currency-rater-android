package com.sanik.currencyrater

import androidx.lifecycle.LiveData
import com.sanik.currencyrater.db.dao.FavouritesDao
import com.sanik.currencyrater.db.data.CurrencyRateWithDate
import com.sanik.currencyrater.network.api.FavouritesApi
import com.sanik.currencyrater.repository.FavouriteRatesRepository
import com.sanik.currencyrater.viewmodels.FavouriteRatesViewModel
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.spy
import org.mockito.junit.MockitoJUnitRunner
import java.util.*
import org.mockito.Mockito.`when` as _when

@RunWith(MockitoJUnitRunner::class)
class FavouriteRatesViewModelTest {

    /*private lateinit var mockFavouriteRatesRepository: FavouriteRatesRepository
    private lateinit var liveData: LiveData<List<CurrencyRateWithDate>>

    private val fakeListOfRates = arrayListOf(
            CurrencyRateWithDate(0, 0, "A", "B", 10.0, Calendar.getInstance()),
            CurrencyRateWithDate(1, 0, "A", "B", 7.0, Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, -1) }),
            CurrencyRateWithDate(2, 1, "C", "D", 7.0, Calendar.getInstance()),
            CurrencyRateWithDate(3, 1, "C", "D", 10.0, Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, -1) })
    )

    @Test
    fun test_fillingRatesListWIthChange() {
        // todo: finish test
        mockFavouriteRatesRepository = FavouriteRatesRepository(mock(FavouritesDao::class.java), mock(FavouritesApi::class.java))
        spy(mockFavouriteRatesRepository)
        _when(mockFavouriteRatesRepository.getFavouriteRatesForToday())
                .thenReturn(liveData)
        val viewModel = FavouriteRatesViewModel(mockFavouriteRatesRepository)
        assertThat(getFromLiveData(viewModel.favouriteRates).size, equalTo(2))
    }*/
}