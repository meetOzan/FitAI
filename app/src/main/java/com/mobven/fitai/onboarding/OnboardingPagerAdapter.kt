package com.mobven.fitai.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.onboarding.screens.FirstOnboardingFragment
import com.mobven.fitai.onboarding.screens.FourthOnboardingFragment
import com.mobven.fitai.onboarding.screens.SecondOnboardingFragment
import com.mobven.fitai.onboarding.screens.ThirdOnboardingFragment

class OnboardingPagerAdapter(
    private val fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FirstOnboardingFragment()
            1 -> SecondOnboardingFragment()
            2 -> ThirdOnboardingFragment()
            3 -> FourthOnboardingFragment()
            else -> FirstOnboardingFragment()
        }
    }

    fun increaseCurrentItem() {
        val currentItem = fragmentActivity.findViewById<ViewPager2>(R.id.onboardingViewPager).currentItem
        val nextItem = currentItem + 1
        fragmentActivity.findViewById<ViewPager2>(R.id.onboardingViewPager).setCurrentItem(nextItem, true)
    }

}