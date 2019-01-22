package com.sanik.currencyrater.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sanik.currencyrater.R
import com.sanik.currencyrater.databinding.AddFavouriteFragmentBinding
import com.sanik.currencyrater.utilities.InjectorUtil
import com.sanik.currencyrater.viewmodels.AddFavouriteViewModel

class AddFavouriteFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var viewModel: AddFavouriteViewModel
    private lateinit var binding: AddFavouriteFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = AddFavouriteFragmentBinding.inflate(inflater, container, false)
        this.binding = binding

        val factory = InjectorUtil.provideAddFavouriteViewModelFactory(requireContext())
        viewModel = ViewModelProviders.of(this, factory).get(AddFavouriteViewModel::class.java)
        val spinnerFromCodeAdapter = createSimpleAdapter()
        val spinnerToCodeAdapter = createSimpleAdapter()
        val spinnerFromNameAdapter = createSimpleAdapter()
        val spinnerToNameAdapter = createSimpleAdapter()

        viewModel.currencyInfoCodeList.observe(viewLifecycleOwner, Observer {codeList ->
            if (codeList != null && codeList.isNotEmpty()) {
                spinnerFromCodeAdapter.clear()
                spinnerFromCodeAdapter.addAll(codeList)

                spinnerToCodeAdapter.clear()
                spinnerToCodeAdapter.addAll(codeList)
                viewModel.currencyInfoCodeList.removeObservers(viewLifecycleOwner)
            }
        })

        viewModel.currencyInfoNameList.observe(viewLifecycleOwner, Observer {nameList ->
            if (nameList != null && nameList.isNotEmpty()) {
                spinnerFromNameAdapter.clear()
                spinnerFromNameAdapter.addAll(nameList)

                spinnerToNameAdapter.clear()
                spinnerToNameAdapter.addAll(nameList)
                viewModel.currencyInfoNameList.removeObservers(viewLifecycleOwner)
            }
        })

        with(binding){
            spFromCode.adapter = spinnerFromCodeAdapter
            spToCode.adapter = spinnerToCodeAdapter
            spFromName.adapter = spinnerFromNameAdapter
            spToName.adapter = spinnerToNameAdapter
        }


        return binding.root
    }

    override fun onStart() {
        super.onStart()
        with(binding){
            spFromCode.onItemSelectedListener = this@AddFavouriteFragment
            spToCode.onItemSelectedListener = this@AddFavouriteFragment
            spFromName.onItemSelectedListener = this@AddFavouriteFragment
            spToName.onItemSelectedListener = this@AddFavouriteFragment

            spFromCode.setSelection(0)
            spToCode.setSelection(0)
        }
    }

    private fun createSimpleAdapter() =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item)
                    .apply { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // do nothing
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent?.id){
            R.id.sp_from_code -> selectNameInSpinnerByCode(parent.getItemAtPosition(position) as String, binding.spFromName)
            R.id.sp_from_name -> selectCodeInSpinnerByName(parent.getItemAtPosition(position) as String, binding.spFromCode)

            R.id.sp_to_code -> selectNameInSpinnerByCode(parent.getItemAtPosition(position) as String, binding.spToName)
            R.id.sp_to_name -> selectCodeInSpinnerByName(parent.getItemAtPosition(position) as String, binding.spToCode)
        }
    }

    private fun selectNameInSpinnerByCode(code: String, spinner: Spinner){
        val correspondingPositionInSpinnerName = viewModel.getNamePositionByCode(code)
        if (correspondingPositionInSpinnerName != -1 && spinner.selectedItemPosition != correspondingPositionInSpinnerName){
            spinner.setSelection(correspondingPositionInSpinnerName)
        }
    }

    private fun selectCodeInSpinnerByName(name: String, spinner: Spinner){
        val correspondingPositionInSpinnerName = viewModel.getCodePositionByName(name)
        if (correspondingPositionInSpinnerName != -1 && spinner.selectedItemPosition != correspondingPositionInSpinnerName){
            spinner.setSelection(correspondingPositionInSpinnerName)
        }
    }
}
