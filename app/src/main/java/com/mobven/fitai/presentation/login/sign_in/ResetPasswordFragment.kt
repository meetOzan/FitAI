package com.mobven.fitai.presentation.login.sign_in

import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentResetPasswordBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.login.sign_in.viewmodel.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment :
    BaseFragment<FragmentResetPasswordBinding>(FragmentResetPasswordBinding::inflate) {
    private val viewModel: SignInViewModel by viewModels()
    override fun observeUi() {
        binding.resetPasswordButton.setOnClickListener {
            val editTextPassword = binding.editTextResetPassword.text.toString()
            val editTextPasswordAgain = binding.editTextResetPasswordConfirm.text.toString()

            binding.resetPassword.helperText = viewModel.validPassword(editTextPassword)
            binding.resetPasswordConfirm.helperText =
                viewModel.isSamePassword(editTextPassword, editTextPasswordAgain)

            if (allFieldsValid()) {
                val navOptions =
                    NavOptions.Builder()
                        .setPopUpTo(R.id.resetPasswordFragment, true)
                        .build()
                findNavController().navigate(
                    R.id.action_resetPasswordFragment_to_resetPasswordSuccessFragment,
                    null,
                    navOptions
                )
            }
        }
    }

    private fun allFieldsValid(): Boolean {
        return binding.resetPassword.helperText == null &&
                binding.resetPasswordConfirm.helperText == null
    }
}