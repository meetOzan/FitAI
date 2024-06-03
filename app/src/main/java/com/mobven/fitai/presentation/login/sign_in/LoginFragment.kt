package com.mobven.fitai.presentation.login.sign_in

import android.util.Patterns
import com.mobven.fitai.databinding.FragmentLoginBinding
import com.mobven.fitai.presentation.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    override fun observeUi() {
        emailFocusListener()
        passwordFocusListener()

        binding.loginButton.setOnClickListener {
            if (binding.loginEmail.helperText == null && binding.loginPassword.helperText == null){
                val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                navigate(action)
            }
        }

        binding.tvRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
            navigate(action)
        }

        binding.loginForgotPassword.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToOTPFragment()
            navigate(action)
        }
    }

    private fun emailFocusListener() {
        binding.editTextEmailLogin.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.loginEmail.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {

        val emailText = binding.editTextEmailLogin.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "E-posta adresiniz hatalı!"
        }

        return null
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
        if (passwordText != "1111" ) {
            return "Parolanız eksik veya hatalı!"
        }

        return null
    }


}


