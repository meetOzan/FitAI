package com.mobven.fitai.presentation.home.nutrition

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobven.fitai.presentation.home.screens.DietTypeFragment
import com.mobven.fitai.presentation.home.screens.FoodAllergiesFragment
import com.mobven.fitai.presentation.home.screens.GoalsFragment
import com.mobven.fitai.presentation.home.screens.OtherHealthProblemFragment
import com.mobven.fitai.presentation.home.screens.PlanCreatingFragment

class NutritionPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OtherHealthProblemFragment()
            1 -> GoalsFragment()
            2 -> FoodAllergiesFragment()
            3 -> DietTypeFragment()
            4 -> PlanCreatingFragment()
            else -> PlanCreatingFragment()
        }
    }

}