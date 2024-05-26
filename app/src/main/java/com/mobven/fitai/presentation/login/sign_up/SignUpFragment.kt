package com.mobven.fitai.presentation.login.sign_up

import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentSignUpBinding
import com.mobven.fitai.presentation.login.sign_up.adapter.SignUpPagerAdapter

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override fun observeUi() {
        binding.toolbar.toolbarBack.setOnClickListener {
            if (binding.signUpViewPager.currentItem == 0) {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            } else {
                binding.signUpViewPager.currentItem -= 1
            }
        }
        binding.signUpViewPager.adapter = SignUpPagerAdapter(requireActivity())
    }

}