package com.mobven.fitai.presentation.home.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobven.fitai.R
import com.mobven.fitai.infrastructure.string_resource.StringResourceProvider
import com.mobven.fitai.presentation.home.adapter.CategoryItem
import com.mobven.fitai.presentation.home.calendar.CalendarItem
import com.mobven.fitai.presentation.login.sign_up.model.ListSelectorItem
import com.mobven.fitai.util.enums.CategoryType
import com.mobven.fitai.util.enums.HomeFragmentType
import com.mobven.fitai.util.enums.SignUpSelectorType
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
@RequiresApi(Build.VERSION_CODES.O)
class HomeViewModel @Inject constructor(
    private val stringRes: StringResourceProvider,
) : ViewModel() {
    private val _homeUiState = MutableLiveData(HomeUiState())
    val homeUiState: LiveData<HomeUiState> = _homeUiState

    private val dayFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern(stringRes.getString(R.string.eeee))
    private val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern(stringRes.getString(R.string.dd))

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.GetSelectorItem -> {
                getSignUpSelectorList(action.fragmentType)
            }
            is HomeAction.GetCategoryItem -> {
                getCategoryItems()
            }
            is HomeAction.GetCalendarItem -> {
                getDate()
            }
        }
    }

    private fun getDate() {
        val tempDateList = mutableListOf<CalendarItem>()
        for (i in 0 until 10) {
            val date = LocalDate.now().minusDays(i.toLong())
            val dayName = date.format(dayFormatter).take(3)
            val dateStr = date.format(dateFormatter)
            val isSelected = i == 0
            tempDateList.add(
                CalendarItem(
                    date = dateStr,
                    dayName = dayName,
                    isSelected = isSelected,
                )
            )
            _homeUiState.value = _homeUiState.value?.copy(dateList = tempDateList)
        }
    }

    private fun getCategoryItems() {
        _homeUiState.value =
            _homeUiState.value?.copy(
                trainingCategoryList =
                listOf(
                    CategoryItem(
                        name = stringRes.getString(R.string.fitness),
                        image = R.drawable.pilates_woman,
                        categoryType = CategoryType.TRAINING,
                    ),
                    CategoryItem(
                        name = stringRes.getString(R.string.hiit),
                        image = R.drawable.hiit_woman,
                        categoryType = CategoryType.TRAINING,
                    ),
                    CategoryItem(
                        name = stringRes.getString(R.string.yoga),
                        image = R.drawable.yoga_man,
                        categoryType = CategoryType.TRAINING,
                    ),
                    CategoryItem(
                        name = stringRes.getString(R.string.pilates),
                        image = R.drawable.yoga_woman,
                        categoryType = CategoryType.TRAINING,
                    )
                ),
                foodCategoryList =
                listOf(
                    CategoryItem(
                        name = stringRes.getString(R.string.breakfast),
                        image = R.drawable.breakfast_category,
                        categoryType = CategoryType.NUTRITION,
                    ),
                    CategoryItem(
                        name = stringRes.getString(R.string.snack),
                        image = R.drawable.snack_categories,
                        categoryType = CategoryType.NUTRITION,
                    )
                ),
            )
    }

    private fun getSignUpSelectorList(fragmentType: HomeFragmentType) {
        _homeUiState.value =
            HomeUiState(
                signUpSelectorList =
                when (fragmentType) {
                    HomeFragmentType.DIET ->
                        listOf(
                            ListSelectorItem(
                                title = stringRes.getString(R.string.ketogenic),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                                image = R.drawable.ketogenic,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.pescetarian),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                                image = R.drawable.pesketarian,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.vegan),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                                image = R.drawable.vegan,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.vegetarian),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                                image = R.drawable.vegetarian,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.traditional),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                                image = R.drawable.traditional,
                            )
                        )

                    HomeFragmentType.GOALS ->
                        listOf(
                            ListSelectorItem(
                                title = stringRes.getString(R.string.healthy_life),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.muscle_gain),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.weight_gain),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.weight_loss),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            )
                        )

                    HomeFragmentType.OTHER_HEALTH_PROBLEM ->
                        listOf(
                            ListSelectorItem(
                                title = stringRes.getString(R.string.celiac),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.diabetes_1),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.diabetes_2),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.tension),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.intolerance_allergy),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            )
                        ).reversed()

                    HomeFragmentType.PREFERRED_SPORT ->
                        listOf(
                            ListSelectorItem(
                                title = stringRes.getString(R.string.all),
                                isSelected = false,
                                type = SignUpSelectorType.CHECKBOX,
                                image = R.drawable.all_select,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.yoga),
                                isSelected = false,
                                type = SignUpSelectorType.CHECKBOX,
                                image = R.drawable.yoga,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.fitness),
                                isSelected = false,
                                type = SignUpSelectorType.CHECKBOX,
                                image = R.drawable.fitness,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.running),
                                isSelected = false,
                                type = SignUpSelectorType.CHECKBOX,
                                image = R.drawable.running,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.walking),
                                isSelected = false,
                                type = SignUpSelectorType.CHECKBOX,
                                image = R.drawable.walking,
                            )
                        ).reversed()

                    HomeFragmentType.SPORT_BODY ->
                        listOf(
                            ListSelectorItem(
                                title = stringRes.getString(R.string.all),
                                isSelected = false,
                                type = SignUpSelectorType.CHECKBOX,
                                image = R.drawable.all_select,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.shoulder_arms),
                                isSelected = false,
                                type = SignUpSelectorType.CHECKBOX,
                                image = R.drawable.arms,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.chest),
                                isSelected = false,
                                type = SignUpSelectorType.CHECKBOX,
                                image = R.drawable.chest,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.belly_back),
                                isSelected = false,
                                type = SignUpSelectorType.CHECKBOX,
                                image = R.drawable.belly,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.hip),
                                isSelected = false,
                                type = SignUpSelectorType.CHECKBOX,
                                image = R.drawable.hips,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.leg),
                                isSelected = false,
                                type = SignUpSelectorType.CHECKBOX,
                                image = R.drawable.legs,
                            ),
                        ).reversed()

                    HomeFragmentType.SPORT_OFTEN ->
                        listOf(
                            ListSelectorItem(
                                title = stringRes.getString(R.string.as_much_as_offered),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.on_two_times_week),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.three_four_times_week),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            ),
                            ListSelectorItem(
                                title = stringRes.getString(R.string.five_six_times_week),
                                isSelected = false,
                                type = SignUpSelectorType.RADIO,
                            )
                        ).reversed()
                },
            )
    }
}

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String = "",
    val signUpSelectorList: List<ListSelectorItem> = emptyList(),
    val trainingCategoryList: List<CategoryItem> = emptyList(),
    val foodCategoryList: List<CategoryItem> = emptyList(),
    val dateList: MutableList<CalendarItem> = mutableListOf()
) {
    companion object {
        fun initial() =
            HomeUiState(
                isLoading = true,
            )
    }
}
