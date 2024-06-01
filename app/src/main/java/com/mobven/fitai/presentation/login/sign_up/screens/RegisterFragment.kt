package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.databinding.FragmentRegisterBinding
import com.mobven.fitai.presentation.base.BaseFragment

typealias RDirections = RegisterFragmentDirections

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    override fun observeUi() {
        binding.btnSignUpContinue.setOnClickListener {
            navigate(RDirections.actionRegisterFragmentToSignUpFragment())
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }
}
