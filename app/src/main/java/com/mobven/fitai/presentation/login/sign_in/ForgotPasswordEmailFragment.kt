package com.mobven.fitai.presentation.login.sign_in


import androidx.fragment.app.viewModels
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
            val action = ForgotPasswordEmailFragmentDirections.actionForgotPasswordEmailFragmentToResetPasswordEmailFragment()
            navigate(action)
        }

        binding.toolbarForgotPassword.toolbarBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.btnForgotPasswordConfirm.setOnClickListener {
            val emailText = binding.editTextForgotPasswordEmail.text.toString()
            binding.emailContainer.helperText = viewModel.validEmail(emailText)
            if (binding.emailContainer.helperText == null) {
                val action =
                    ForgotPasswordEmailFragmentDirections.actionForgotPasswordEmailFragmentToOTPFragment()
                navigate(action)
            }
        }
    }
}