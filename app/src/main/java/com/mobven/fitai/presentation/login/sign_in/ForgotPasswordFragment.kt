package com.mobven.fitai.presentation.login.sign_in

import androidx.fragment.app.viewModels
import com.mobven.fitai.databinding.FragmentForgotPasswordBinding
import com.mobven.fitai.presentation.base.BaseFragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.presentation.login.sign_in.viewmodel.SignInViewModel


class ForgotPasswordFragment :
    BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate) {
    private val viewModel: SignInViewModel by viewModels()

    override fun observeUi() {
        binding.tvLoginWithEmail.setOnClickListener {
            findNavController().navigate(R.id.action_resetPasswordEmailFragment_to_forgotPasswordEmailFragment)
        }

        binding.toolbarForgotPassword.toolbarBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.btnForgotPasswordConfirm.setOnClickListener {

            val emailText = binding.editTextForgotPassword.text.toString()
            binding.phoneContainer.helperText = viewModel.validPhone(emailText)
            if (binding.phoneContainer.helperText == null) {
                findNavController().navigate(R.id.action_resetPasswordEmailFragment_to_OTPFragment)
            }
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}