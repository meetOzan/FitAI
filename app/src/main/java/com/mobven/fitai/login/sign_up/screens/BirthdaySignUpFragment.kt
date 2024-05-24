package com.mobven.fitai.login.sign_up.screens

import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentBirthdaySignUpBinding

class BirthdaySignUpFragment :
    BaseFragment<FragmentBirthdaySignUpBinding>(FragmentBirthdaySignUpBinding::inflate) {

    override fun observeUi() {
        binding.btnBirthdayContinue.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
        }
    }


}