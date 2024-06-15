package com.mobven.fitai.presentation.login

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint

typealias AuthDirections = AuthFragmentDirections

@AndroidEntryPoint
class AuthFragment : BaseFragment<FragmentAuthBinding>(FragmentAuthBinding::inflate) {

    override fun observeUi() {
        binding.registerButton.setOnClickListener {
            val registerAction = AuthDirections.actionAuthFragmentToRegisterFragment()
            navigate(registerAction)
        }

        binding.loginButton.setOnClickListener {
            val loginAction = AuthDirections.actionAuthFragmentToLoginFragment()
            navigate(loginAction)
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }
}