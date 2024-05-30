package com.mobven.fitai.presentation.login.sign_up.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobven.fitai.presentation.login.sign_up.screens.BirthdaySignUpFragment
import com.mobven.fitai.presentation.login.sign_up.screens.GenderSignUpFragment
import com.mobven.fitai.presentation.login.sign_up.screens.GoalSignUpFragment
import com.mobven.fitai.presentation.login.sign_up.screens.GoalsFragment
import com.mobven.fitai.presentation.login.sign_up.screens.HeightSignUpFragment
import com.mobven.fitai.presentation.login.sign_up.screens.RegisterFragment
import com.mobven.fitai.presentation.login.sign_up.screens.WeightSignUpFragment

class SignUpPagerAdapter(
    private val fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RegisterFragment()
            1 -> GenderSignUpFragment()
            2 -> HeightSignUpFragment()
            3 -> WeightSignUpFragment()
            4 -> GoalSignUpFragment()
            5 -> BirthdaySignUpFragment()
            6 -> GoalsFragment()
            else -> GoalsFragment()
        }
    }
}
