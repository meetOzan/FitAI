package com.mobven.fitai.presentation.onboarding.screens

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentFourthOnBoardingBinding
import com.mobven.fitai.presentation.onboarding.OnboardingFragmentDirections

typealias ObDirections = OnboardingFragmentDirections

class FourthOnboardingFragment : BaseFragment<FragmentFourthOnBoardingBinding>(FragmentFourthOnBoardingBinding::inflate){

    override fun observeUi() {
        binding.btnOnboarding4Skip.setOnClickListener {
            val onBoardingAction = ObDirections.actionOnboardingFragmentToAuthFragment()
            navigate(onBoardingAction)
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}