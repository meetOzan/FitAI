package com.mobven.fitai.onboarding.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentFirstOnBoardingBinding

class FirstOnboardingFragment : BaseFragment<FragmentFirstOnBoardingBinding>(FragmentFirstOnBoardingBinding::inflate) {

    override fun observeUi() {
        binding.btnOnboarding1Continue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.onboardingViewPager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.onboardingViewPager).setCurrentItem(nextItem, true)
        }
    }

}