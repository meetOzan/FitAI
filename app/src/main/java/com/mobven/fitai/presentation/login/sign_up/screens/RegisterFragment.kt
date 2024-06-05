package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.databinding.FragmentRegisterBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.login.sign_in.viewmodel.SignInViewModel
import com.mobven.fitai.presentation.login.sign_up.SignUpFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

typealias RDirections = RegisterFragmentDirections

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    private val viewModel: SignInViewModel by viewModels()

    override fun observeUi() {
        with(binding) {
            btnSignUpContinue.setOnClickListener {
                val editTextEmail = binding.editTextEmailSignUp.text.toString()
                val editTextPassword = binding.editTextPasswordSignUp.text.toString()
                val editTextPasswordAgain = binding.editTextPasswordAgainSignUp.text.toString()
                val editTextUserName = binding.editTextNicknameSignUp.text.toString()

                textInputLayoutEmailSignUp.helperText = viewModel.validEmail(editTextEmail)
                textInputLayoutPasswordSignUp.helperText = viewModel.validPassword(editTextPassword)
                textInputLayoutPasswordAgainSignUp.helperText = viewModel.isSamePassword(
                    editTextPassword,
                    editTextPasswordAgain
                )
                textInputLayoutNicknameSignUp.helperText = viewModel.isEmpty(editTextUserName)
                textInputLayoutNameSignUp.helperText = viewModel.isEmpty(editTextUserName)
                textInputLayoutSurnameSignUp.helperText = viewModel.isEmpty(editTextUserName)

                if (allFieldsValid()) {
                    val currentItem =
                        requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
                    val nextItem = currentItem + 1
                    requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager)
                        .setCurrentItem(nextItem, true)
                }

            }

            binding.tvLoginSignUp.setOnClickListener {
                navigate(RDirections.actionRegisterFragmentToLoginFragment())
            }
        }
    }

    private fun allFieldsValid(): Boolean {
        return binding.textInputLayoutEmailSignUp.helperText == null &&
                binding.textInputLayoutPasswordSignUp.helperText == null &&
                binding.textInputLayoutPasswordAgainSignUp.helperText == null &&
                binding.textInputLayoutNicknameSignUp.helperText == null
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }
}
