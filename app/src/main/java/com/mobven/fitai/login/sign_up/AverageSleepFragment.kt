package com.mobven.fitai.login.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentAverageSleepBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.SignUpSelectorType

class AverageSleepFragment : Fragment() {

    private lateinit var binding: FragmentAverageSleepBinding
    private val adapter = SignUpListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAverageSleepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sleepList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.zero_six_hour),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.six_ten_hour),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.more_than_ten),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            )
        ).reversed()

        adapter.submitList(sleepList)
        binding.rvAverageSleep.adapter = adapter

    }
}