package com.mobven.fitai.presentation.login.sign_in

import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentResetPasswordBinding
import com.mobven.fitai.presentation.base.BaseFragment

class ResetPasswordFragment :
    BaseFragment<FragmentResetPasswordBinding>(FragmentResetPasswordBinding::inflate) {

    override fun observeUi() {
        binding.btnResetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_resetPasswordFragment_to_resetPasswordSuccessFragment2)
        }
        binding.toolbarOtpEmail.toolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.toolbarOtpEmail.toolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun navigate(action: NavDirections) {
        val navOptions =
            NavOptions.Builder()
                .setPopUpTo(R.id.resetPasswordFragment, true)
                .build()
        findNavController().navigate(action, navOptions)
    }

}