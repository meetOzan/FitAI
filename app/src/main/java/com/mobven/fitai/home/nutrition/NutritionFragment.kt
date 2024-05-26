package com.mobven.fitai.home.nutrition

import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentNutritionBinding

class NutritionFragment :
    BaseFragment<FragmentNutritionBinding>(FragmentNutritionBinding::inflate) {

    override fun observeUi() {
        super.observeUi()

        with(binding) {

            toolbar.toolbarBack.setOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }

            vpNutrition.adapter = NutritionPagerAdapter(requireActivity())
            indicatorNutrition.attachTo(vpNutrition)

        }

    }

}