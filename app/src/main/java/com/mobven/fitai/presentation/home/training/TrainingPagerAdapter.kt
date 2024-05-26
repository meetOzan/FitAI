package com.mobven.fitai.presentation.home.training

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobven.fitai.home.screens.GoalsFragmentTraining
import com.mobven.fitai.home.screens.HealthProblemFragment
import com.mobven.fitai.home.screens.PlanCreatingFragment
import com.mobven.fitai.home.screens.PreferredSportFragment
import com.mobven.fitai.home.screens.SportBodyPartFragment
import com.mobven.fitai.home.screens.SportOftenFragment

class TrainingPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HealthProblemFragment()
            1 -> GoalsFragmentTraining()
            2 -> PreferredSportFragment()
            3 -> SportOftenFragment()
            4 -> SportBodyPartFragment()
            5 -> PlanCreatingFragment()
            else -> PlanCreatingFragment()
        }
    }

}