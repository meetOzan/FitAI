package com.mobven.fitai.presentation.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobven.fitai.presentation.onboarding.screens.FirstOnboardingFragment
import com.mobven.fitai.presentation.onboarding.screens.FourthOnboardingFragment
import com.mobven.fitai.presentation.onboarding.screens.SecondOnboardingFragment
import com.mobven.fitai.presentation.onboarding.screens.ThirdOnboardingFragment

class OnboardingPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstOnboardingFragment()
            1 -> SecondOnboardingFragment()
            2 -> ThirdOnboardingFragment()
            3 -> FourthOnboardingFragment()
            else -> FirstOnboardingFragment()
        }
    }

}