package com.mobven.fitai.login.sign_up.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentAverageWaterBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.SignUpSelectorType

class AverageWaterFragment : Fragment() {

    private lateinit var binding: FragmentAverageWaterBinding
    private val adapter = SignUpListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAverageWaterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val waterList = listOf(

            SignUpSelectorItem(
                title = getString(R.string.zero_one_liter),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.two_three_liter),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.more_than_three),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
        ).reversed()

        adapter.submitList(waterList)
        binding.rvAverageWater.adapter = adapter

    }
}