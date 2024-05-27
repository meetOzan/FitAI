package com.mobven.fitai.presentation.home.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentDietTypeBinding
import com.mobven.fitai.presentation.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.presentation.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType

class DietTypeFragment : BaseFragment<FragmentDietTypeBinding>(FragmentDietTypeBinding::inflate) {

    private val adapter = SignUpListAdapter()

    override fun observeUi() {

        val dietTypeList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.ketogenic),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.pescetarian),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.vegan),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.vegetarian),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.traditional),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            )
        )

        adapter.submitList(dietTypeList)
        binding.rvDietType.adapter = adapter

        binding.btnDietTypeContinue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.vp_nutrition).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.vp_nutrition).setCurrentItem(nextItem, true)
        }
    }

}