package com.mobven.fitai.login.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentGoalsBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.SignUpSelectorType


class SportOftenFragment : Fragment() {

    private lateinit var binding: FragmentGoalsBinding
    private val adapter = SignUpListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGoalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sportOftenList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.as_much_as_offered),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.on_two_times_week),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.three_four_times_week),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.five_six_times_week),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            )
        ).reversed()

        adapter.submitList(sportOftenList)
        binding.rvGoals.adapter = adapter

    }

}