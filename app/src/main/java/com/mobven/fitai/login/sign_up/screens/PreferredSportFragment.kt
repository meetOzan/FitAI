package com.mobven.fitai.login.sign_up.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentGoalsBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType

class PreferredSportFragment : BaseFragment<FragmentGoalsBinding>(FragmentGoalsBinding::inflate) {

    private val adapter = SignUpListAdapter()

    override fun observeUi() {

        val preferredSportList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.all),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.yoga),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.fitness),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.running),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.walking),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
        ).reversed()

        adapter.submitList(preferredSportList)
        binding.rvGoals.adapter = adapter

        binding.btnGoalsContinue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).setCurrentItem(nextItem, true)
        }
    }
}