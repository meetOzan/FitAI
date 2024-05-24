package com.mobven.fitai.home.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentHealthProblemBinding

class HealthProblemFragment :
    BaseFragment<FragmentHealthProblemBinding>(FragmentHealthProblemBinding::inflate) {

    override fun observeUi() {
        binding.btnHealthProblemContinue.setOnClickListener {
            val currentItem =
                requireActivity().findViewById<ViewPager2>(R.id.vp_training).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.vp_training)
                .setCurrentItem(nextItem, true)
        }
    }

}