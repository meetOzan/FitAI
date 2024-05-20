package com.mobven.fitai.login.sign_up.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobven.fitai.login.sign_up.screens.AverageSleepFragment
import com.mobven.fitai.login.sign_up.screens.AverageWaterFragment
import com.mobven.fitai.login.sign_up.screens.BirthdaySignUpFragment
import com.mobven.fitai.login.sign_up.screens.DailyMovementFragment
import com.mobven.fitai.login.sign_up.screens.DietTypeFragment
import com.mobven.fitai.login.sign_up.screens.FoodAllergiesFragment
import com.mobven.fitai.login.sign_up.screens.GenderSignUpFragment
import com.mobven.fitai.login.sign_up.screens.GoalSignUpFragment
import com.mobven.fitai.login.sign_up.screens.GoalsFragment
import com.mobven.fitai.login.sign_up.screens.HealthProblemFragment
import com.mobven.fitai.login.sign_up.screens.HeightSignUpFragment
import com.mobven.fitai.login.sign_up.screens.OtherHealthProblemFragment
import com.mobven.fitai.login.sign_up.screens.PlanCreatingFragment
import com.mobven.fitai.login.sign_up.screens.PlansFragment
import com.mobven.fitai.login.sign_up.screens.PreferredSportFragment
import com.mobven.fitai.login.sign_up.screens.RegisterFragment
import com.mobven.fitai.login.sign_up.screens.SportBodyPartFragment
import com.mobven.fitai.login.sign_up.screens.SportOftenFragment
import com.mobven.fitai.login.sign_up.screens.WeightSignUpFragment

class SignUpPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 19

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> RegisterFragment()
            1 -> GenderSignUpFragment()
            2 -> HeightSignUpFragment()
            3 -> WeightSignUpFragment()
            4 -> GoalSignUpFragment()
            5 -> BirthdaySignUpFragment()
            6 -> GoalsFragment()
            7 -> PlansFragment()
            8 -> HealthProblemFragment()
            9 -> PreferredSportFragment()
            10 -> SportOftenFragment()
            11 -> SportBodyPartFragment()
            12 -> OtherHealthProblemFragment()
            13 -> FoodAllergiesFragment()
            14 -> DietTypeFragment()
            15 -> DailyMovementFragment()
            16 -> AverageSleepFragment()
            17 -> AverageWaterFragment()
            18 -> PlanCreatingFragment()
            else -> throw Error("Invalid position for $position")
        }
    }

}