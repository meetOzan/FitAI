package com.mobven.fitai.presentation.home


import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentHomeBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.home.adapter.CategoryItem
import com.mobven.fitai.presentation.home.adapter.HomeCategoryAdapter
import com.mobven.fitai.presentation.home.calendar.CalendarItem
import com.mobven.fitai.presentation.home.calendar.HomeCalendarAdapter
import com.mobven.fitai.presentation.home.personal_plan.PersonalPlanData
import com.mobven.fitai.presentation.home.personal_plan.PlanAdapter
import com.mobven.fitai.presentation.home.viewmodel.HomeAction
import com.mobven.fitai.presentation.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

typealias HDirections = HomeFragmentDirections

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val calendarAdapter = HomeCalendarAdapter()
    private val trainingAdapter = HomeCategoryAdapter()
    private val foodAdapter = HomeCategoryAdapter()
    private var isExpanded = false
    private lateinit var llPlanCard: LinearLayout
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

        getUserData()

        val arrow : ImageView = requireView().findViewById(R.id.ivArrow)

        binding.cardViewPlan.setOnClickListener {
            if (isExpanded) {
                arrow.setImageResource(R.drawable.ic_arrow_down)
                llPlanCard.visibility = View.GONE
            } else {
                arrow.setImageResource(R.drawable.ic_arrow_up)
                llPlanCard.visibility = View.VISIBLE
            }
            isExpanded = !isExpanded
        }

    }

    private fun getUserData() {

        binding.cardViewImage.setImageResource(R.drawable.pilates)
        val planRecyclerView : RecyclerView = requireView().findViewById(R.id.plan_recycler_view)
        llPlanCard  = requireView().findViewById(R.id.llPlanCardDetail)
        planRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        planRecyclerView.setHasFixedSize(true)
        val planArrayList : ArrayList<PersonalPlanData> = arrayListOf()

        val header: TextView = requireView().findViewById(R.id.tvHeader)
        val cardHeader : TextView = requireView().findViewById(R.id.tv_card_header)
        val time : TextView = requireView().findViewById(R.id.tvTime)
        val kcal : TextView = requireView().findViewById(R.id.tvKcal)

        header.text = "Setler"
        cardHeader.text = "Pilates"
        time.text = "15 dakika"
        kcal.text = "150 kcal"


       val imageId : Array<Int> = arrayOf(
            R.drawable.ic_warm_up,
            R.drawable.ic_main_set,
            R.drawable.ic_cool_down
        )

        val name : Array<String> = arrayOf(
            "Isınma Seti",
            "Ana Set",
            "Soğuma Seti"
        )

        val detail : Array<String> = arrayOf(
            "Mat",
            "Mat - Direnç Bandı",
            "Mat"
        )

        for (i in imageId.indices) {
            val planData = PersonalPlanData(imageId[i], name[i], detail[i])
            planArrayList.add(planData)
        }

        planRecyclerView.adapter = PlanAdapter(planArrayList)
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

            with(includeHomePersonalizedFood) {
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
