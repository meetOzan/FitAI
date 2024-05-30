package com.mobven.fitai.presentation.home.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.R.string.training_plan_ai_powered
import com.mobven.fitai.databinding.FragmentIntroductionBinding
import com.mobven.fitai.presentation.base.BaseFragment

class IntroductionFragment(
    private val introductionType: String,
) : BaseFragment<FragmentIntroductionBinding>(FragmentIntroductionBinding::inflate) {
    override fun observeUi() {
        if (introductionType == "training") {
            binding.tvIntroductionTitle.text = getString(training_plan_ai_powered)
            binding.introductionDescription.text = getString(R.string.training_plan_please_answer)

            binding.btnIntroductionContinue.setOnClickListener {
                val currentItem =
                    requireActivity().findViewById<ViewPager2>(R.id.vp_training).currentItem
                val nextItem = currentItem + 1
                requireActivity().findViewById<ViewPager2>(R.id.vp_training)
                    .setCurrentItem(nextItem, true)
            }
        } else {
            binding.tvIntroductionTitle.text = getString(R.string.nutrition_plan_ai_powered)
            binding.introductionDescription.text = getString(R.string.nutrition_plan_please_answer)

            binding.btnIntroductionContinue.setOnClickListener {
                val currentItem =
                    requireActivity().findViewById<ViewPager2>(R.id.vp_nutrition).currentItem
                val nextItem = currentItem + 1
                requireActivity().findViewById<ViewPager2>(R.id.vp_nutrition)
                    .setCurrentItem(nextItem, true)
            }
        }
    }
}
