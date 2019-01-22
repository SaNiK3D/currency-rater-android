package com.sanik.currencyrater.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sanik.currencyrater.R
import com.sanik.currencyrater.databinding.FavouritesListItemBinding
import com.sanik.currencyrater.db.data.CurrencyRateChange
import com.sanik.currencyrater.viewmodels.CurrencyRateChangeViewModel

class FavouriteRatesAdapter : ListAdapter<CurrencyRateChange, FavouriteRatesAdapter.ViewHolder>(FavouriteRatesDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.favourites_list_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.bind(it)
        }
    }

    class ViewHolder(
        private val binding: FavouritesListItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(currencyRateChange: CurrencyRateChange) {
            binding.viewModel = CurrencyRateChangeViewModel(
                itemView.context,
                currencyRateChange
            )
            binding.executePendingBindings()
        }
    }
}