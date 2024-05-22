package com.mobven.fitai.login

import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentAuthBinding

class AuthFragment : BaseFragment<FragmentAuthBinding>(FragmentAuthBinding::inflate) {

    override fun observeUi() {
        super.observeUi()

        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_signUpFragment)
        }
    }

}