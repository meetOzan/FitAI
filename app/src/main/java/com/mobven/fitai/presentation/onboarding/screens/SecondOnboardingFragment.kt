package com.mobven.fitai.presentation.onboarding.screens

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentSecondOnBoardingBinding

class SecondOnboardingFragment : BaseFragment<FragmentSecondOnBoardingBinding>(FragmentSecondOnBoardingBinding::inflate) {

    override fun observeUi() {
        binding.btnOnboarding2Skip.setOnClickListener {
            val onBoardingAction = ObDirections.actionOnboardingFragmentToAuthFragment()
            navigate(onBoardingAction)
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}