package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentAverageWaterBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType

class AverageWaterFragment :
    BaseFragment<FragmentAverageWaterBinding>(FragmentAverageWaterBinding::inflate) {

    private val adapter = SignUpListAdapter()

    override fun observeUi() {

        val waterList = listOf(

            SignUpSelectorItem(
                title = getString(R.string.zero_one_liter),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.two_three_liter),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.more_than_three),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
        ).reversed()

        adapter.submitList(waterList)
        binding.rvAverageWater.adapter = adapter

        binding.btnAverageWaterContinue.setOnClickListener {
            val currentItem =
                requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager)
                .setCurrentItem(nextItem, true)
        }

    }
}