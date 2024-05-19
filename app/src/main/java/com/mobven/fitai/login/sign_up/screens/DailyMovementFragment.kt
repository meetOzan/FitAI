package com.mobven.fitai.login.sign_up.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentDailyMovementBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.SignUpSelectorType


class DailyMovementFragment : Fragment() {

    private lateinit var binding: FragmentDailyMovementBinding
    private var adapter = SignUpListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDailyMovementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dailyMovementList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.almost_never),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.rarely),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.sometimes),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.often),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            ),
            SignUpSelectorItem(
                title = getString(R.string.always),
                isSelected = false,
                type = SignUpSelectorType.RADIO,
            )
        ).reversed()

        adapter.submitList(dailyMovementList)
        binding.rvDailyMovement.adapter = adapter

    }
}