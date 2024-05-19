package com.mobven.fitai.login.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentGenderSignUpBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter

class GenderSignUpFragment : Fragment() {

    private lateinit var binding: FragmentGenderSignUpBinding
    private val adapter = SignUpListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGenderSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val genderList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.female_gender),
                isSelected = false
            ),
            SignUpSelectorItem(
                title = getString(R.string.male_gender),
                isSelected = false
            ),
            SignUpSelectorItem(
                title = getString(R.string.other_gender),
                isSelected = false
            )
        )

        adapter.submitList(genderList)
        binding.rvGender.adapter = adapter

    }
}