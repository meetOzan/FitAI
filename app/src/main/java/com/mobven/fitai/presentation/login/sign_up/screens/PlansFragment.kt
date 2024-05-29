package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentGoalsBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.presentation.login.sign_up.model.ListSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType

class PlansFragment : BaseFragment<FragmentGoalsBinding>(FragmentGoalsBinding::inflate) {
    private val adapter = SignUpListAdapter()

    override fun observeUi() {
        val plansList =
            listOf(
                ListSelectorItem(
                    title = getString(R.string.all),
                    isSelected = false,
                    type = SignUpSelectorType.CHECKBOX,
                ),
                ListSelectorItem(
                    title = getString(R.string.eating_plan),
                    isSelected = false,
                    type = SignUpSelectorType.CHECKBOX,
                ),
                ListSelectorItem(
                    title = getString(R.string.training_plan),
                    isSelected = false,
                    type = SignUpSelectorType.CHECKBOX,
                ),
                ListSelectorItem(
                    title = getString(R.string.healthy_life),
                    isSelected = false,
                    type = SignUpSelectorType.CHECKBOX,
                ),
                ListSelectorItem(
                    title = getString(R.string.intermittent_fasting),
                    isSelected = false,
                    type = SignUpSelectorType.CHECKBOX,
                ),
                ListSelectorItem(
                    title = getString(R.string.water_tracking),
                    isSelected = false,
                    type = SignUpSelectorType.CHECKBOX,
                ),
            ).reversed()

        adapter.submitList(plansList)
        binding.rvGoals.adapter = adapter

        binding.btnGoalsContinue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).setCurrentItem(nextItem, true)
        }
    }
}
