package com.mobven.fitai.presentation.login.sign_up

import android.widget.ImageView
import android.widget.ProgressBar
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentSignUpBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.login.sign_up.adapter.SignUpPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    override fun observeUi() {
        with(binding){
            signUpViewPager.adapter = SignUpPagerAdapter(requireActivity())

            toolbar.toolbarBack.setOnClickListener {
                if (signUpViewPager.currentItem == 1) {
                    requireActivity().findViewById<ImageView>(R.id.toolbar_back).visibility = ProgressBar.INVISIBLE
                }
                signUpViewPager.currentItem -= 1
            }
        }
    }
}
