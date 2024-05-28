package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentDailyMovementBinding
import com.mobven.fitai.presentation.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.presentation.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType


class DailyMovementFragment : BaseFragment<FragmentDailyMovementBinding>(FragmentDailyMovementBinding::inflate) {

    private var adapter = SignUpListAdapter()

    override fun observeUi() {

        val dailyMovementList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.almost_never),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.rarely),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.sometimes),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.often),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.always),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            )
        ).reversed()

        adapter.submitList(dailyMovementList)
        binding.rvDailyMovement.adapter = adapter

        binding.btnDailyMovementContinue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).setCurrentItem(nextItem, true)
        }

    }

}