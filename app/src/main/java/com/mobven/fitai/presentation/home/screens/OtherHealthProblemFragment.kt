package com.mobven.fitai.presentation.home.screens

import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentOtherHealthProblemBinding
import com.mobven.fitai.presentation.home.viewmodel.HomeAction
import com.mobven.fitai.presentation.home.viewmodel.HomeViewModel
import com.mobven.fitai.presentation.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.presentation.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.enums.HomeFragmentType
import com.mobven.fitai.util.enums.SignUpSelectorType
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OtherHealthProblemFragment : BaseFragment<FragmentOtherHealthProblemBinding>(FragmentOtherHealthProblemBinding::inflate) {

    private val adapter = SignUpListAdapter()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun observeUi() {
        homeViewModel.homeUiState.observe(viewLifecycleOwner) { homeState ->
            when {
                homeState.isError -> {
                    handleError(homeState.errorMessage)
                }

                homeState.isLoading -> {
                    handleLoading()
                }

                else -> {
                    handleSuccess(homeState.signUpSelectorList)
                }

            }
        }
    }

    private fun handleSuccess(healthProblems: List<SignUpSelectorItem>) {
        adapter.submitList(healthProblems)
        binding.rvOtherHealthProblem.adapter = adapter

        binding.btnOtherHealthProblemContinue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.vp_nutrition).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.vp_nutrition).setCurrentItem(nextItem, true)
        }
    }

    private fun handleError(error: String) {
        println(error)
    }

    private fun handleLoading() {
        println(getString(R.string.loading))
    }

    override fun callInitialViewModelFunction() {
        homeViewModel.onAction(HomeAction.GetSelectorItem(HomeFragmentType.OTHER_HEALTH_PROBLEM))
    }

}