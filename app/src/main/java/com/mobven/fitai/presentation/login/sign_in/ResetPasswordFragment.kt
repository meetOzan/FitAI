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

        passwordFocusListener()
        checkPassword()

        binding.resetPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_resetPasswordFragment_to_resetPasswordSuccessFragment)
        }
        binding.toolbarResetPassword.toolbarBack.setOnClickListener {
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

    private fun checkPassword() {
        binding.editTextResetPasswordConfirm.setOnFocusChangeListener { _, focused ->
            if (!focused && binding.editTextResetPassword.text != binding.editTextResetPasswordConfirm) {
                binding.resetPasswordConfirm.helperText = getString(R.string.passwords_not_matched)
            }
        }
    }

    private fun passwordFocusListener() {
        binding.editTextResetPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.resetPassword.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.editTextResetPassword.text.toString()
        if (passwordText.length < 8) {
            return getString(R.string.password_eight_char)
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return getString(R.string.password_least_one_upper_case)
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())) {
            return getString(R.string.password_least_one_lower_case)
        }

        return null
    }
}