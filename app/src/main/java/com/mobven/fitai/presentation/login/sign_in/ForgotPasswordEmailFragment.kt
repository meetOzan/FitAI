package com.mobven.fitai.presentation.login.sign_in


import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentForgotPasswordEmailBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.login.sign_in.viewmodel.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordEmailFragment :
    BaseFragment<FragmentForgotPasswordEmailBinding>(FragmentForgotPasswordEmailBinding::inflate) {
    private val viewModel: SignInViewModel by viewModels()

    override fun observeUi() {

        binding.tvLoginWithNumber.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordEmailFragment_to_resetPasswordEmailFragment)
        }

        binding.toolbarForgotPassword.toolbarBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.btnForgotPasswordConfirm.setOnClickListener {
            val emailText = binding.editTextForgotPasswordEmail.text.toString()
            binding.emailContainer.helperText = viewModel.validEmail(emailText)
            if (binding.emailContainer.helperText == null) {
                findNavController().navigate(R.id.action_forgotPasswordEmailFragment_to_OTPFragment)
            }
        }
    }
}