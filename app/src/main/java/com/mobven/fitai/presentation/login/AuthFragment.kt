package com.mobven.fitai.presentation.login

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentAuthBinding

class AuthFragment : BaseFragment<FragmentAuthBinding>(FragmentAuthBinding::inflate) {

    override fun observeUi() {
        super.observeUi()

        binding.registerButton.setOnClickListener {
            val action = AuthFragmentDirections.actionAuthFragmentToRegisterFragment()
            navigate(action)
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}