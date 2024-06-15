package com.mobven.fitai.presentation.home.nutrition

import androidx.fragment.app.viewModels
import com.mobven.fitai.R
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentNutritionBinding
import com.mobven.fitai.presentation.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NutritionFragment :
    BaseFragment<FragmentNutritionBinding>(FragmentNutritionBinding::inflate) {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun observeUi() {
        super.observeUi()

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
        binding.toolbarNutrition.toolbarBack.setOnClickListener {
            if (binding.vpNutrition.currentItem == 0) {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            } else {
                binding.vpNutrition.currentItem -= 1
            }
        }
        binding.vpNutrition.adapter = NutritionPagerAdapter(requireActivity())
        binding.indicatorNutrition.attachTo(binding.vpNutrition)
    }

    private fun handleError(error: String) {
        println(error)
    }

    private fun handleLoading() {
        println(getString(R.string.loading))
    }

}