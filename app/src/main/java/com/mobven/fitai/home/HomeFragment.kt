package com.mobven.fitai.home

import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun observeUi() {
        with(binding) {

            includeFoodPlanItem.tvPlanName.text = context?.getString(R.string.eating_plan)

            ivFoodPlanAdd.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_nutritionFragment)
            }

        }
    }

}