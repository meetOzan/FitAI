package com.mobven.fitai.presentation.home.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentOtherHealthProblemBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType

class OtherHealthProblemFragment : BaseFragment<FragmentOtherHealthProblemBinding>(FragmentOtherHealthProblemBinding::inflate) {

    private val adapter = SignUpListAdapter()

    override fun observeUi() {

        val healthProblems = listOf(
            SignUpSelectorItem(
                title = getString(R.string.celiac),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.diabetes_1),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.diabetes_2),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.tension),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.intolerance_allergy),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            )
        ).reversed()

        adapter.submitList(healthProblems)
        binding.rvOtherHealthProblem.adapter = adapter

        binding.btnOtherHealthProblemContinue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.vp_nutrition).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.vp_nutrition).setCurrentItem(nextItem, true)
        }

    }

}