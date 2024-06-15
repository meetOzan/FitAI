package com.mobven.fitai.presentation.onboarding.screens

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.common.SharedPreferencesHelper
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentFourthOnBoardingBinding
import com.mobven.fitai.presentation.onboarding.OnboardingFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

typealias ObDirections = OnboardingFragmentDirections

@AndroidEntryPoint
class FourthOnboardingFragment : BaseFragment<FragmentFourthOnBoardingBinding>(FragmentFourthOnBoardingBinding::inflate){

    override fun observeUi() {
        binding.btnOnboarding4Skip.setOnClickListener {
            SharedPreferencesHelper.saveIsFirstLaunch(requireContext(), true)
            val onBoardingAction = ObDirections.actionOnboardingFragmentToAuthFragment()
            navigate(onBoardingAction)
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}