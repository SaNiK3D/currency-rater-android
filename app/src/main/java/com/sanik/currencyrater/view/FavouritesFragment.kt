package com.sanik.currencyrater.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanik.currencyrater.R
import com.sanik.currencyrater.adapters.FavouriteRatesAdapter
import com.sanik.currencyrater.databinding.FavouritesFragmentBinding
import com.sanik.currencyrater.utilities.InjectorUtil
import com.sanik.currencyrater.viewmodels.FavouriteRatesViewModel


class FavouritesFragment : Fragment() {

    private lateinit var viewModel: FavouriteRatesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FavouritesFragmentBinding.inflate(inflater, container, false)
        val adapter = FavouriteRatesAdapter()
        binding.favouriteList.adapter = adapter

        val factory = InjectorUtil.provideFavouritesViewModelFactory(requireContext())
        viewModel = ViewModelProviders.of(this, factory).get(FavouriteRatesViewModel::class.java)
        viewModel.favouriteRates.observe(viewLifecycleOwner, Observer { favouriteList ->
            if (favouriteList == null || favouriteList.isEmpty()){
                binding.hasFavourites = true
            } else {
                adapter.submitList(favouriteList)
                binding.hasFavourites = false
            }
        })

        binding.fab.setOnClickListener {
            it.findNavController().navigate(R.id.action_my_rates_fragment_nav_to_addFavourite)
        }

        return binding.root
    }
}
