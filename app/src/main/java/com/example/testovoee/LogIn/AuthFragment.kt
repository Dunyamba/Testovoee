package com.example.testovoee.LogIn

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testovoee.R
import com.example.testovoee.Utils.SAVED_TOKEN
import com.example.testovoee.Utils.SaveToken
import com.example.testovoee.databinding.FragmentAuthBinding
import com.example.testovoee.entities.LogIn.LogIn

class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private val saveToken = SaveToken()
    lateinit var storage: SharedPreferences

    companion object {
        fun newInstance() = AuthFragment()
    }

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, AuthVMFactory()).get(AuthViewModel::class.java)
        storage = requireContext().getSharedPreferences(SAVED_TOKEN, Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)

        binding.inputLogin.addTextChangedListener {
            binding.btnLogIn.isEnabled =
                !(binding.inputLogin.text.isEmpty() || binding.inputPassword.text.isEmpty())
        }

        binding.inputPassword.addTextChangedListener {
            binding.btnLogIn.isEnabled =
                !(binding.inputLogin.text.isEmpty() || binding.inputPassword.text.isEmpty())
        }

        binding.btnLogIn.setOnClickListener {
            binding.progress.visibility = View.VISIBLE
            binding.btnLogIn.isEnabled = false

            viewModel.auth(
                LogIn(
                    login = binding.inputLogin.text.toString(),
                    password = binding.inputPassword.text.toString()
                ), storage
            )

            viewModel.token.observe(viewLifecycleOwner) { token ->
                saveToken.saveToken(token, storage)
                when (token) {
                    "" -> {}
                    null -> {

                        viewModel.responseError.observe(viewLifecycleOwner) {
                            if (it != null) {
                                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                                viewModel.responseError.value = null
                            }
                        }

                        binding.progress.visibility = View.GONE
                        binding.btnLogIn.isEnabled = true
                    }

                    else -> {
                        try {
                            findNavController().navigate(R.id.log_in)
                        } catch (e: Exception) {
                            Log.d("navigate", e.toString())
                        }

                    }
                }
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }

}