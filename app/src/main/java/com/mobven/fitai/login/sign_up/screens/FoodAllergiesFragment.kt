package com.mobven.fitai.login.sign_up.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentFoodAllergiesBinding

class FoodAllergiesFragment : BaseFragment<FragmentFoodAllergiesBinding>(FragmentFoodAllergiesBinding::inflate) {

    override fun observeUi() {
        binding.btnFoodAllergiesContinue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.vp_nutrition).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.vp_nutrition).setCurrentItem(nextItem, true)
        }
    }

}