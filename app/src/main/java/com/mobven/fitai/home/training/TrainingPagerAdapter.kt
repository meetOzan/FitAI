package com.mobven.fitai.home.training

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobven.fitai.login.sign_up.screens.GoalsFragment
import com.mobven.fitai.login.sign_up.screens.HealthProblemFragment
import com.mobven.fitai.login.sign_up.screens.PlanCreatingFragment
import com.mobven.fitai.login.sign_up.screens.PreferredSportFragment
import com.mobven.fitai.login.sign_up.screens.SportBodyPartFragment
import com.mobven.fitai.login.sign_up.screens.SportOftenFragment

class TrainingPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HealthProblemFragment()
            1 -> GoalsFragment()
            2 -> PreferredSportFragment()
            3 -> SportOftenFragment()
            4 -> SportBodyPartFragment()
            5 -> PlanCreatingFragment()
            else -> PlanCreatingFragment()
        }
    }

}