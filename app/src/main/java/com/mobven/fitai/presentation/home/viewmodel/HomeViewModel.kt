package com.mobven.fitai.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobven.fitai.R
import com.mobven.fitai.infrastructure.string_resource.StringResourceProvider
import com.mobven.fitai.presentation.login.sign_up.model.ListSelectorItem
import com.mobven.fitai.util.enums.HomeFragmentType
import com.mobven.fitai.util.enums.SignUpSelectorType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val stringRes: StringResourceProvider,
    ) : ViewModel() {
        private val _homeUiState = MutableLiveData(HomeUiState())
        val homeUiState: LiveData<HomeUiState> = _homeUiState

        fun onAction(action: HomeAction) {
            when (action) {
                is HomeAction.GetSelectorItem -> {
                    getSignUpSelectorList(action.fragmentType)
                }
            }
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
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.pescetarian),
                                        isSelected = false,
                                        type = SignUpSelectorType.RADIO,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.vegan),
                                        isSelected = false,
                                        type = SignUpSelectorType.RADIO,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.vegetarian),
                                        isSelected = false,
                                        type = SignUpSelectorType.RADIO,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.traditional),
                                        isSelected = false,
                                        type = SignUpSelectorType.RADIO,
                                    ),
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
                                    ),
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
                                    ),
                                ).reversed()

                            HomeFragmentType.PREFERRED_SPORT ->
                                listOf(
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.all),
                                        isSelected = false,
                                        type = SignUpSelectorType.CHECKBOX,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.yoga),
                                        isSelected = false,
                                        type = SignUpSelectorType.CHECKBOX,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.fitness),
                                        isSelected = false,
                                        type = SignUpSelectorType.CHECKBOX,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.running),
                                        isSelected = false,
                                        type = SignUpSelectorType.CHECKBOX,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.walking),
                                        isSelected = false,
                                        type = SignUpSelectorType.CHECKBOX,
                                    ),
                                ).reversed()

                            HomeFragmentType.SPORT_BODY ->
                                listOf(
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.all),
                                        isSelected = false,
                                        type = SignUpSelectorType.CHECKBOX,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.shoulder_arms),
                                        isSelected = false,
                                        type = SignUpSelectorType.CHECKBOX,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.chest),
                                        isSelected = false,
                                        type = SignUpSelectorType.CHECKBOX,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.belly_back),
                                        isSelected = false,
                                        type = SignUpSelectorType.CHECKBOX,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.hip),
                                        isSelected = false,
                                        type = SignUpSelectorType.CHECKBOX,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.leg),
                                        isSelected = false,
                                        type = SignUpSelectorType.CHECKBOX,
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
                                    ),
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
) {
    companion object {
        fun initial() =
            HomeUiState(
                isLoading = true,
            )
    }
}
