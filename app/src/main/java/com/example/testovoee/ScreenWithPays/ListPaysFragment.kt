package com.example.testovoee.ScreenWithPays

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testovoee.R
import com.example.testovoee.Utils.SAVED_TOKEN
import com.example.testovoee.Utils.SaveToken
import com.example.testovoee.databinding.FragmentListPaysBinding

class ListPaysFragment : Fragment() {


    companion object {
        fun newInstance() = ListPaysFragment()
    }

    private lateinit var binding: FragmentListPaysBinding

    private lateinit var viewModel: ListPaysViewModel
    val saveToken = SaveToken()
    lateinit var storage: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, PaymentsVMFactory()).get(ListPaysViewModel::class.java)
        storage = requireContext().getSharedPreferences(SAVED_TOKEN, Context.MODE_PRIVATE)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListPaysBinding.inflate(layoutInflater, container, false)

        viewModel.getToken(saveToken.getSavedToken(storage))
        viewModel.getList()
        
        viewModel.listPayments.observe(viewLifecycleOwner) {
            val adapter = RecyclerAdapter(it)
            binding.listPayments.adapter = adapter
        }

        binding.logOut.setOnClickListener {
            saveToken.deleteToken(storage)
            findNavController().navigate(R.id.log_out)
            saveToken.getSavedToken(storage)?.let { it1 -> Log.d("deleted token", it1) }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListPaysViewModel::class.java)
        // TODO: Use the ViewModel
    }

}