package com.mobven.fitai.presentation.login.sign_in

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.databinding.FragmentResetPasswordEmailBinding
import com.mobven.fitai.presentation.base.BaseFragment

class ResetPasswordEmailFragment :
    BaseFragment<FragmentResetPasswordEmailBinding>(FragmentResetPasswordEmailBinding::inflate) {

    override fun observeUi() {
        binding.btnForgotPasswordConfirm.setOnClickListener {
            val action =
                ResetPasswordEmailFragmentDirections.actionResetPasswordEmailFragmentToOTPFragment()
            navigate(action)
        }

        binding.toolbarForgotPassword.toolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}