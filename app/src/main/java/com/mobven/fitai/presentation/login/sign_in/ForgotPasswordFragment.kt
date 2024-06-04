package com.mobven.fitai.presentation.login.sign_in


import com.mobven.fitai.databinding.FragmentForgotPasswordBinding
import com.mobven.fitai.presentation.base.BaseFragment


class ForgotPasswordFragment : BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate) {

    override fun observeUi() {
        binding.tvLoginWithEmail.setOnClickListener {
            val action = ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToForgotPasswordEmailFragment()
            navigate(action)
        }

        binding.toolbarForgotPassword.toolbarBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.btnForgotPasswordConfirm.setOnClickListener {
            val action = ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToOTPFragment2()
            navigate(action)
        }
    }


}