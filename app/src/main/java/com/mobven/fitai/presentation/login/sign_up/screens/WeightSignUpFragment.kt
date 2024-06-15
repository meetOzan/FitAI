package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentWeightSignUpBinding
import com.mobven.fitai.presentation.base.BaseFragment

class WeightSignUpFragment : BaseFragment<FragmentWeightSignUpBinding>(FragmentWeightSignUpBinding::inflate) {
    override fun observeUi() {
        binding.btnWeightContinue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).setCurrentItem(nextItem, true)
        }
    }
}
