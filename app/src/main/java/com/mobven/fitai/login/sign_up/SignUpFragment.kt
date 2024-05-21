package com.mobven.fitai.login.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.databinding.FragmentSignUpBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpPagerAdapter

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.toolbarBack.setOnClickListener {
            if (binding.signUpViewPager.currentItem == 0) {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            } else {
                binding.signUpViewPager.currentItem -= 1
            }
        }

        binding.signUpViewPager.adapter = SignUpPagerAdapter(requireActivity())

    }

}