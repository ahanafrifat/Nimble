package com.ahanaf.nimble.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ahanaf.nimble.R
import com.ahanaf.nimble.databinding.LoginFragmentBinding
import com.ahanaf.nimble.util.AppUtils

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val viewModel: LoginViewModel by viewModels()
    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.login_fragment, container, false)
        _binding = LoginFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(binding.root)
        initMessage()

        with(binding) {
            login.setOnClickListener {
                if (viewModel.validateEmail(email) && viewModel.validatePassword(password)) {
                    gotoHome()
                }
//                gotoHome()
            }
        }
    }

    private fun initMessage() {
        viewModel.message.observe(viewLifecycleOwner) { message ->
            message?.let {
                AppUtils.message(binding.root, it)
            }
        }
    }

    private fun gotoHome() {
        navController.navigate(R.id.action_loginFragment_to_navigation_home)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}