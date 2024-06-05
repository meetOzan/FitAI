package com.mobven.fitai.presentation.login.sign_in

import androidx.fragment.app.viewModels
import com.mobven.fitai.databinding.FragmentForgotPasswordBinding
import com.mobven.fitai.presentation.base.BaseFragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.presentation.login.sign_in.viewmodel.SignInViewModel


class ForgotPasswordFragment :
    BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate) {
    private val viewModel: SignInViewModel by viewModels()

    override fun observeUi() {
        binding.tvLoginWithEmail.setOnClickListener {
            val action =
                ForgotPasswordFragmentDirections.actionResetPasswordEmailFragmentToForgotPasswordEmailFragment()
            navigate(action)
        }

        binding.toolbarForgotPassword.toolbarBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.btnForgotPasswordConfirm.setOnClickListener {

            val emailText = binding.editTextForgotPassword.text.toString()
            binding.phoneContainer.helperText = viewModel.validPhone(emailText)
            if (binding.phoneContainer.helperText == null) {
                val action =
                    ForgotPasswordFragmentDirections.actionResetPasswordEmailFragmentToOTPFragment()
                navigate(action)
            }
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}