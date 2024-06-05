package com.mobven.fitai.presentation.login.sign_in


import androidx.fragment.app.viewModels
import com.mobven.fitai.databinding.FragmentLoginBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.login.sign_in.viewmodel.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel: SignInViewModel by viewModels()
    override fun observeUi() {

        binding.toolbarLogin.toolbarBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.loginButton.setOnClickListener {

            val editTextEmail = binding.editTextEmailLogin.text.toString()
            binding.loginEmail.helperText = viewModel.validEmail(editTextEmail)

            val editTextPassword = binding.editTextPasswordLogin.text.toString()
            binding.loginPassword.helperText = viewModel.validPassword(editTextPassword)

            if (allFieldsValid())
            {
                val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                navigate(action)
            }
        }

        binding.tvRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
            navigate(action)
        }

        binding.loginForgotPassword.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment()
            navigate(action)
        }
    }

    private fun allFieldsValid() : Boolean{
        return binding.loginEmail.helperText == null &&
               binding.loginPassword.helperText == null
    }
}