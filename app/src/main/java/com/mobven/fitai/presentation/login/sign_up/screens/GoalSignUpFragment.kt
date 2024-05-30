package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentGoalSignUpBinding

class GoalSignUpFragment :
    BaseFragment<FragmentGoalSignUpBinding>(FragmentGoalSignUpBinding::inflate) {

    override fun observeUi() {
        with(binding) {
            btnWeightGoalContinue.setOnClickListener {
                val currentItem =
                    requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
                val nextItem = currentItem + 1
                requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager)
                    .setCurrentItem(nextItem, true)
            }
        }
    }

}