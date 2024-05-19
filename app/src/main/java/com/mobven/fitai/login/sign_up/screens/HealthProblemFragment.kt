package com.mobven.fitai.login.sign_up.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentHealthProblemBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter


class HealthProblemFragment : Fragment() {

    private lateinit var binding: FragmentHealthProblemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHealthProblemBinding.inflate(inflater, container, false)
        return binding.root
    }

}