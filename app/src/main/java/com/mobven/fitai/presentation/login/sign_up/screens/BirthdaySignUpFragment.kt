package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentBirthdaySignUpBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.login.sign_up.SignUpFragmentDirections

typealias BDayDirections = SignUpFragmentDirections

class BirthdaySignUpFragment :
    BaseFragment<FragmentBirthdaySignUpBinding>(FragmentBirthdaySignUpBinding::inflate) {
    override fun observeUi() {
        binding.btnBirthdayContinue.setOnClickListener {
            val currentItem =
                requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager)
                .setCurrentItem(nextItem, true)
        }
    }
}
