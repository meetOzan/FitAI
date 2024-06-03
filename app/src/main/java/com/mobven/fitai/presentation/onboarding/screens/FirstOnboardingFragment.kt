package com.mobven.fitai.presentation.onboarding.screens

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentFirstOnBoardingBinding

class FirstOnboardingFragment : BaseFragment<FragmentFirstOnBoardingBinding>(FragmentFirstOnBoardingBinding::inflate) {

    override fun observeUi() {
        binding.btnOnboarding1Skip.setOnClickListener {
            val onBoardingAction = ObDirections.actionOnboardingFragmentToAuthFragment()
            navigate(onBoardingAction)
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}