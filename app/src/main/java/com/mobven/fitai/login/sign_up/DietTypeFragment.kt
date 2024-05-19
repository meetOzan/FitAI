package com.mobven.fitai.login.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentDietTypeBinding
import com.mobven.fitai.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.SignUpSelectorType

class DietTypeFragment : Fragment() {

    private lateinit var binding: FragmentDietTypeBinding
    private val adapter = SignUpListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDietTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dietTypeList = listOf(
            SignUpSelectorItem(
                title = getString(R.string.ketogenic),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.pescetarian),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.vegan),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.vegetarian),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            ),
            SignUpSelectorItem(
                title = getString(R.string.traditional),
                isSelected = false,
                type = SignUpSelectorType.RADIO
            )
        )

        adapter.submitList(dietTypeList)
        binding.rvDietType.adapter = adapter

    }

}