package com.mobven.fitai.login.sign_up.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentSportBodyPartBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType


class SportBodyPartFragment : BaseFragment<FragmentSportBodyPartBinding>(FragmentSportBodyPartBinding::inflate) {

    private val adapter = SignUpListAdapter()

    override fun observeUi() {

        val bodyPartList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.all),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.shoulder_arms),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.chest),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.belly_back),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.hip),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.leg),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
        ).reversed()

        adapter.submitList(bodyPartList)
        binding.rvBodyPartSport.adapter = adapter

        binding.btnBodyPartContinue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.vp_training).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.vp_training).setCurrentItem(nextItem, true)
        }
    }

}