package com.mobven.fitai.login.sign_up.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentGoalsBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.SignUpSelectorType

class PlansFragment : Fragment() {

    private lateinit var binding: FragmentGoalsBinding
    private val adapter = SignUpListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGoalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val plansList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.all),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.eating_plan),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.training_plan),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.calorie_control),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.intermittent_fasting),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.water_tracking),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            )
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