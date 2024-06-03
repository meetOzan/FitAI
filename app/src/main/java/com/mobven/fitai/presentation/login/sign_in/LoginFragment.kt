package com.mobven.fitai.presentation.login.sign_in

import android.content.Intent
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.MainActivity
import com.mobven.fitai.databinding.FragmentLoginBinding
import com.mobven.fitai.presentation.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override fun observeUi() {
        binding.btnSignIn.setOnClickListener {
            val loginAction = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            navigate(loginAction)
        }
        binding.toolbarRegister.toolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.loginForgotPassword.setOnClickListener {
            val loginAction = LoginFragmentDirections.actionLoginFragmentToResetPasswordEmailFragment()
            navigate(loginAction)
        }
        binding.registerButton.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }
}