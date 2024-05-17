package com.mobven.fitai.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.databinding.FragmentFourthOnBoardingBinding

class FourthOnboardingFragment : Fragment() {

    private lateinit var binding: FragmentFourthOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

}