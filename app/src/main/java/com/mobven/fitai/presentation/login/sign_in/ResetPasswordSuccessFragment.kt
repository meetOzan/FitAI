package com.mobven.fitai.presentation.login.sign_in

import com.mobven.fitai.databinding.FragmentResetPasswordSuccesBinding
import com.mobven.fitai.presentation.base.BaseFragment

class ResetPasswordSuccessFragment : BaseFragment<FragmentResetPasswordSuccesBinding>(FragmentResetPasswordSuccesBinding::inflate){
    override fun observeUi() {
        binding.loginButton.setOnClickListener {
            val action = ResetPasswordSuccessFragmentDirections.actionResetPasswordSuccessFragmentToLoginFragment()
            navigate(action)
        }
    }
}