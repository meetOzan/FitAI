package com.mobven.fitai.presentation.login.sign_in

import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentResetPasswordSuccesBinding
import com.mobven.fitai.presentation.base.BaseFragment

class ResetPasswordSuccessFragment :
    BaseFragment<FragmentResetPasswordSuccesBinding>(FragmentResetPasswordSuccesBinding::inflate) {

    override fun observeUi() {
        binding.loginButton.setOnClickListener {
            val navOptions =
                NavOptions.Builder()
                    .setPopUpTo(R.id.resetPasswordSuccessFragment, true)
                    .setPopUpTo(R.id.resetPasswordFragment, true)
                    .setPopUpTo(R.id.loginFragment, true)
                    .build()
            findNavController().navigate(
                R.id.action_resetPasswordSuccessFragment_to_loginFragment,
                null,
                navOptions
            )
        }
    }
}