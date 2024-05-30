package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentBirthdaySignUpBinding
import com.mobven.fitai.presentation.login.sign_up.SignUpFragmentDirections

typealias BDayDirections = SignUpFragmentDirections

class BirthdaySignUpFragment :
    BaseFragment<FragmentBirthdaySignUpBinding>(FragmentBirthdaySignUpBinding::inflate) {

    override fun observeUi() {
        binding.btnBirthdayContinue.setOnClickListener {

            val action = BDayDirections.actionSignUpFragmentToHomeFragment()
            navigate(action)
        }
    }

    override fun navigate(action: NavDirections) {
        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.signUpFragment, true)
            .setPopUpTo(R.id.authFragment, true)
            .build()
        findNavController().navigate(action,navOptions)
    }

}