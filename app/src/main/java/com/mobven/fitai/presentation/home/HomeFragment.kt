package com.mobven.fitai.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentHomeBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.home.adapter.CategoryItem
import com.mobven.fitai.presentation.home.adapter.HomeCategoryAdapter
import com.mobven.fitai.presentation.home.calendar.CalendarItem
import com.mobven.fitai.presentation.home.calendar.HomeCalendarAdapter
import com.mobven.fitai.presentation.home.viewmodel.HomeAction
import com.mobven.fitai.presentation.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

typealias HDirections = HomeFragmentDirections

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val calendarAdapter = HomeCalendarAdapter()
    private val trainingAdapter = HomeCategoryAdapter()
    private val foodAdapter = HomeCategoryAdapter()

    private val homeViewModel: HomeViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
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
                    handleSuccess(
                        trainingList = homeState.trainingCategoryList,
                        foodList = homeState.foodCategoryList,
                        dateList = homeState.dateList
                    )
                }
            }
        }

        binding.ivHomeProfile.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
            navigate(action)
        }

        binding.tvHomeDailyGoals.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToBottomSheetFragment()
            navigate(action)
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun handleSuccess(
        trainingList: List<CategoryItem>,
        foodList: List<CategoryItem>,
        dateList: List<CalendarItem>
    ) {
        with(binding) {
            with(includeHomeIntakeCalorie) {
                ivCalorieCardIcon.setImageResource(
                    R.drawable.intake_calorie,
                )
                tvCalorieCardTitle.text = getString(R.string.intake_calorie)
                this.tvCalorieCardValue.text = getString(R.string._900_kcal)
            }

            with(includeHomeBurnedCalorie) {
                ivCalorieCardIcon.setImageResource(
                    R.drawable.expend_calorie,
                )
                tvCalorieCardTitle.text = getString(R.string.burned_calorie)
                this.tvCalorieCardValue.text = getString(R.string._1300_kcal)
            }

            with(includeHomeRemainingCalorie) {
                ivCalorieCardIcon.setImageResource(
                    R.drawable.calorie_goal,
                )
                tvCalorieCardTitle.text = getString(R.string.daily_goal)
                this.tvCalorieCardValue.text = getString(R.string._2500_kcal)
            }

            with(includeHomePersonalizedTraining){
                ivPersonalizedCardIcon.setImageResource(
                    R.drawable.dumbell,
                )
                tvCreatePersonalized.text = getString(R.string.create_personalized_training)
                cardHomePersonalized.setOnClickListener{
                    findNavController().navigate(R.id.action_homeFragment_to_trainingFragment)
                }
            }

            with(includeHomePersonalizedFood){
                ivPersonalizedCardIcon.setImageResource(
                    R.drawable.pan,
                )
                tvCreatePersonalized.text = getString(R.string.create_personalized_food)
                cardHomePersonalized.setOnClickListener {
                    findNavController().navigate(R.id.action_homeFragment_to_nutritionFragment)
                }
            }

            ivHomeProfile.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
            }

            ebtnHomeAddExercises.setOnClickListener {
                navigate(HDirections.actionHomeFragmentToAddTrainingFragment())
            }

            ebtnHomeAddFood.setOnClickListener {
                navigate(HDirections.actionHomeFragmentToAddFoodFragment())
            }

            calendarAdapter.submitList(dateList)
            trainingAdapter.submitList(trainingList)
            foodAdapter.submitList(foodList)

            rvHomeCalendar.adapter = calendarAdapter
            rvHomeTrainingCategory.adapter = trainingAdapter
            rvHomeFoodCategory.adapter = foodAdapter
        }
    }

    private fun handleError(error: String) {
        println(error)
    }

    private fun handleLoading() {
        println(getString(R.string.loading))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun callInitialViewModelFunction() {
        homeViewModel.onAction(HomeAction.GetCategoryItem)
        homeViewModel.onAction(HomeAction.GetCalendarItem)
    }
}
