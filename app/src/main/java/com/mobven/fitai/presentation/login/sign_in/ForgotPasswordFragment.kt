package com.mobven.fitai.presentation.login.sign_in

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.databinding.FragmentForgotPasswordBinding
import com.mobven.fitai.presentation.base.BaseFragment

class ForgotPasswordFragment :
    BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate) {

    override fun observeUi() {
        binding.btnForgotPasswordConfirm.setOnClickListener {
            val action = ForgotPasswordFragmentDirections.actionResetPasswordEmailFragmentToOTPFragment()
            navigate(action)
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}