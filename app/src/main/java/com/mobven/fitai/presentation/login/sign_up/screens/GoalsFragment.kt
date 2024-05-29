package com.mobven.fitai.presentation.login.sign_up.screens

import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentGoalsBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.login.sign_up.adapter.SignUpListAdapter
import com.mobven.fitai.presentation.login.sign_up.model.ListSelectorItem
import com.mobven.fitai.presentation.login.sign_up.viewmodel.SignUpAction
import com.mobven.fitai.presentation.login.sign_up.viewmodel.SignUpViewModel
import com.mobven.fitai.util.enums.SignUpFragmentType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GoalsFragment : BaseFragment<FragmentGoalsBinding>(FragmentGoalsBinding::inflate) {
    private val adapter = SignUpListAdapter()
    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun observeUi() {
        signUpViewModel.signUpState.observe(viewLifecycleOwner) { signUpState ->
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

    private fun handleSuccess(goalList: List<ListSelectorItem>) {
        adapter.submitList(goalList)
        binding.rvGoals.adapter = adapter

        binding.btnGoalsContinue.setOnClickListener {
            val action = BDayDirections.actionSignUpFragmentToHomeFragment()
            navigate(action)
        }
    }

    private fun handleError(error: String) {
        println(error)
    }

    private fun handleLoading() {
        println(getString(R.string.loading))
    }

    override fun callInitialViewModelFunction() {
        signUpViewModel.onAction(SignUpAction.GetSelectorItem(SignUpFragmentType.GOALS))
    }

    override fun navigate(action: NavDirections) {
        val navOptions =
            NavOptions.Builder()
                .setPopUpTo(R.id.signUpFragment, true)
                .setPopUpTo(R.id.authFragment, true)
                .build()
        findNavController().navigate(action, navOptions)
    }
}
