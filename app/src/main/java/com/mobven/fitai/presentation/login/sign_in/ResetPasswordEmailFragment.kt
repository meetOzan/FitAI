package com.mobven.fitai.presentation.login.sign_in

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.databinding.FragmentResetPasswordBinding
import com.mobven.fitai.presentation.base.BaseFragment

class ResetPasswordEmailFragment :
    BaseFragment<FragmentResetPasswordBinding>(FragmentResetPasswordBinding::inflate) {

    override fun observeUi() {
        binding.resetPasswordButton.setOnClickListener {
            val action =
                ResetPasswordFragmentDirections.actionResetPasswordFragmentToResetPasswordSuccessFragment()
            navigate(action)
        }

        binding.toolbarResetPassword.toolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}