package com.mobven.fitai.presentation.login.sign_up.screens


import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentRegisterBinding
import com.mobven.fitai.presentation.base.BaseFragment


class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    override fun observeUi() {
        binding.btnSignUpContinue.setOnClickListener {
            val currentItem =
                requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager)
                .setCurrentItem(nextItem, true)
        }
    }
}
