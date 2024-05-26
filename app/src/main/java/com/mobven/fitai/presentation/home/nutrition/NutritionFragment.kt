package com.mobven.fitai.presentation.home.nutrition

import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentNutritionBinding

class NutritionFragment :
    BaseFragment<FragmentNutritionBinding>(FragmentNutritionBinding::inflate) {

    override fun observeUi() {
        super.observeUi()

        with(binding) {

            toolbarNutrition.toolbarBack.setOnClickListener {
                if (vpNutrition.currentItem == 0) {
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                } else {
                    vpNutrition.currentItem -= 1
                }
            }

            vpNutrition.adapter = NutritionPagerAdapter(requireActivity())
            indicatorNutrition.attachTo(vpNutrition)

        }

    }

}