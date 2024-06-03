package com.mobven.fitai.presentation.login.sign_in

import android.content.Intent
import android.util.Patterns
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.MainActivity
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentLoginBinding
import com.mobven.fitai.presentation.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override fun observeUi() {

        emailFocusListener()
        passwordFocusListener()

        binding.tvRegister.setOnClickListener {
            if (binding.loginEmail.helperText == null && binding.loginPassword.helperText == null){
                val loginAction = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
                navigate(loginAction)
            }
        }
        binding.toolbarLogin.toolbarBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.loginForgotPassword.setOnClickListener {
            val loginAction = LoginFragmentDirections.actionLoginFragmentToResetPasswordEmailFragment()
            navigate(loginAction)
        }
        binding.loginButton.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

    private fun validEmail(): String? {
        val emailText = binding.editTextEmailLogin.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return getString(R.string.email_incorrect)
        }
        return null
    }

    private fun emailFocusListener() {
        binding.editTextEmailLogin.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.loginEmail.helperText = validEmail()
            }
        }
    }

    private fun passwordFocusListener() {
        binding.editTextPasswordLogin.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.loginPassword.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.editTextPasswordLogin.text.toString()
        if (passwordText != getString(R.string._1111) ) {
            return getString(R.string.password_incorrect)
        }
        return null
    }
}