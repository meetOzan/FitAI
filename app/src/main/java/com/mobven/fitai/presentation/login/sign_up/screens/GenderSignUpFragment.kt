package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentGenderSignUpBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.presentation.login.sign_up.model.ListSelectorItem
import com.mobven.fitai.presentation.login.sign_up.viewmodel.SignUpAction
import com.mobven.fitai.presentation.login.sign_up.viewmodel.SignUpViewModel
import com.mobven.fitai.util.enums.SignUpFragmentType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenderSignUpFragment :
    BaseFragment<FragmentGenderSignUpBinding>(FragmentGenderSignUpBinding::inflate) {
    private val adapter = SignUpListAdapter()
    private val viewModel: SignUpViewModel by viewModels()

    override fun observeUi() {
        viewModel.signUpState.observe(viewLifecycleOwner) { signUpState ->
            when {
                signUpState.isError -> {
                    handleError(signUpState.errorMessage)
                }

                signUpState.isLoading -> {
                    handleLoading()
                }

                else -> {
                    handleSuccess(signUpState.signUpSelectorList)
                }
            }
        }
    }

    private fun handleSuccess(genderList: List<ListSelectorItem>) {
        adapter.submitList(genderList)
        binding.rvGender.adapter = adapter

        binding.btnGenderContinue.setOnClickListener {
            val currentItem =
                requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.sign_up_view_pager)
                .setCurrentItem(nextItem, true)
        }
    }

    private fun handleError(error: String) {
        println(error)
    }

    private fun handleLoading() {
        println(getString(R.string.loading))
    }

    override fun callInitialViewModelFunction() {
        viewModel.onAction(SignUpAction.GetSelectorItem(SignUpFragmentType.GENDER))
    }
}
