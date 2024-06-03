package com.mobven.fitai.presentation.login

import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentAuthBinding

class AuthFragment : BaseFragment<FragmentAuthBinding>(FragmentAuthBinding::inflate) {

    override fun observeUi() {
        super.observeUi()

        binding.registerButton.setOnClickListener {
            val registerAction = AuthFragmentDirections.actionAuthFragmentToRegisterFragment()
            navigate(registerAction)
        }

        binding.loginButton.setOnClickListener {
            val loginAction = AuthFragmentDirections.actionAuthFragmentToLoginFragment()
            navigate(loginAction)
        }
    }

}