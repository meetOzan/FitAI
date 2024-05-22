package com.mobven.fitai.login.sign_up.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentGoalsBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType


class SportOftenFragment : BaseFragment<FragmentGoalsBinding>(FragmentGoalsBinding::inflate) {

    private val adapter = SignUpListAdapter()

    override fun observeUi() {
        val sportOftenList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.as_much_as_offered),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.on_two_times_week),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.three_four_times_week),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.five_six_times_week),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            )
        ).reversed()

        adapter.submitList(sportOftenList)
        binding.rvGoals.adapter = adapter

        binding.btnGoalsContinue.setOnClickListener {
            val currentItem =
                requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager)
                .setCurrentItem(nextItem, true)
        }
    }

}