package com.mobven.fitai.presentation.login.sign_up.screens

import android.widget.ImageView
import android.widget.ProgressBar
import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentHeightSignUpBinding

class HeightSignUpFragment : BaseFragment<FragmentHeightSignUpBinding>(FragmentHeightSignUpBinding::inflate) {

    override fun observeUi() {
        requireActivity().findViewById<ImageView>(R.id.toolbar_back).visibility = ProgressBar.VISIBLE

        binding.btnHeightContinue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).setCurrentItem(nextItem, true)
        }

    }
}