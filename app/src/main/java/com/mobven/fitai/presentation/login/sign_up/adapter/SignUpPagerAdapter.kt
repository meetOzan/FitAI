package com.mobven.fitai.presentation.login.sign_up.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobven.fitai.presentation.login.sign_up.screens.BirthdaySignUpFragment
import com.mobven.fitai.presentation.login.sign_up.screens.GenderSignUpFragment
import com.mobven.fitai.presentation.login.sign_up.screens.GoalSignUpFragment
import com.mobven.fitai.presentation.login.sign_up.screens.GoalsFragment
import com.mobven.fitai.presentation.login.sign_up.screens.HeightSignUpFragment
import com.mobven.fitai.presentation.login.sign_up.screens.WeightSignUpFragment

class SignUpPagerAdapter (
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GenderSignUpFragment()
            1 -> HeightSignUpFragment()
            2 -> WeightSignUpFragment()
            3 -> GoalSignUpFragment()
            4 -> BirthdaySignUpFragment()
            5 -> GoalsFragment()
            else -> GoalsFragment()
        }
    }
}
