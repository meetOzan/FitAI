package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentAverageSleepBinding
import com.mobven.fitai.presentation.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.presentation.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType

class AverageSleepFragment :
    BaseFragment<FragmentAverageSleepBinding>(FragmentAverageSleepBinding::inflate) {

    private val adapter = SignUpListAdapter()

    override fun observeUi() {
        val sleepList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.zero_six_hour),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ), SignUpSelectorItem(
                title = getString(R.string.six_ten_hour),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ), SignUpSelectorItem(
                title = getString(R.string.more_than_ten),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            )
        ).reversed()

        adapter.submitList(sleepList)
        binding.rvAverageSleep.adapter = adapter

        binding.btnAverageSleepContinue.setOnClickListener {
            val currentItem =
                requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager)
                .setCurrentItem(nextItem, true)
        }

    }

}