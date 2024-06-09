package com.mobven.fitai.presentation.onboarding.screens

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.common.SharedPreferencesHelper
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentThirdOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ThirdOnboardingFragment : BaseFragment<FragmentThirdOnBoardingBinding>(FragmentThirdOnBoardingBinding::inflate) {

    override fun observeUi() {
        binding.btnOnboarding3Skip.setOnClickListener {
            SharedPreferencesHelper.saveIsFirstLaunch(requireContext(), true)
            val onBoardingAction = ObDirections.actionOnboardingFragmentToAuthFragment()
            navigate(onBoardingAction)
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}