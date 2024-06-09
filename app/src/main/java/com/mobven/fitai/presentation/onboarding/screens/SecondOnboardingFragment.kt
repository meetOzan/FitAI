package com.mobven.fitai.presentation.onboarding.screens

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.common.SharedPreferencesHelper
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentSecondOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SecondOnboardingFragment : BaseFragment<FragmentSecondOnBoardingBinding>(FragmentSecondOnBoardingBinding::inflate) {

    override fun observeUi() {
        binding.btnOnboarding2Skip.setOnClickListener {
            SharedPreferencesHelper.saveIsFirstLaunch(requireContext(), true)
            val onBoardingAction = ObDirections.actionOnboardingFragmentToAuthFragment()
            navigate(onBoardingAction)
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}