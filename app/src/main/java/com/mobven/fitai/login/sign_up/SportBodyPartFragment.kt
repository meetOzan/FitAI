package com.mobven.fitai.login.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentSportBodyPartBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.SignUpSelectorType


class SportBodyPartFragment : Fragment() {

    private lateinit var binding: FragmentSportBodyPartBinding
    private val adapter = SignUpListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSportBodyPartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bodyPartList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.all),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.shoulder_arms),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.chest),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.belly_back),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.hip),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.leg),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
        )

        adapter.submitList(bodyPartList)
        binding.rvBodyPartSport.adapter = adapter

    }

}