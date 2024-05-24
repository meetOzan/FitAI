package com.mobven.fitai.home.nutrition

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobven.fitai.login.sign_up.screens.DietTypeFragment
import com.mobven.fitai.login.sign_up.screens.FoodAllergiesFragment
import com.mobven.fitai.login.sign_up.screens.GoalsFragment
import com.mobven.fitai.login.sign_up.screens.OtherHealthProblemFragment
import com.mobven.fitai.login.sign_up.screens.PlanCreatingFragment
import com.mobven.fitai.login.sign_up.screens.PlansFragment

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