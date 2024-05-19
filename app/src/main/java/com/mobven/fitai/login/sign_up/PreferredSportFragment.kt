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

class PreferredSportFragment : Fragment() {

    private lateinit var binding: FragmentGoalsBinding
    private val adapter = SignUpListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentGoalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preferredSportList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.all),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.yoga),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.fitness),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.running),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
            SignUpSelectorItem(
                title = getString(R.string.walking),
                isSelected = false,
                type = SignUpSelectorType.CHECKBOX
            ),
        ).reversed()

        adapter.submitList(preferredSportList)
        binding.rvGoals.adapter = adapter

    }
}