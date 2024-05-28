package com.mobven.fitai.presentation.home.training

import androidx.fragment.app.viewModels
import com.mobven.fitai.R
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentTrainingBinding
import com.mobven.fitai.presentation.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrainingFragment : BaseFragment<FragmentTrainingBinding>(FragmentTrainingBinding::inflate) {

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
                    handleSuccess()
                }

            }
        }

    }

    private fun handleSuccess() {
        binding.toolbar.toolbarBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.vpTraining.adapter = TrainingPagerAdapter(requireActivity())
        binding.indicatorTraining.attachTo(binding.vpTraining)
    }

    private fun handleLoading() {
        println(getString(R.string.loading))
    }

    private fun handleError(errorMessage: String) {
        println(errorMessage)
    }

}