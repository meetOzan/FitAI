package com.mobven.fitai.login.sign_up.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.databinding.FragmentPlanCreatingBinding

class PlanCreatingFragment : Fragment() {

    private lateinit var binding: FragmentPlanCreatingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlanCreatingBinding.inflate(inflater, container, false)
        return binding.root
    }

}