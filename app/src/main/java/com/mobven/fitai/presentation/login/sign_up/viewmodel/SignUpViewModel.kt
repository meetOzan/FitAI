package com.mobven.fitai.presentation.login.sign_up.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobven.fitai.R
import com.mobven.fitai.infrastructure.string_resource.StringResourceProvider
import com.mobven.fitai.presentation.login.sign_up.model.ListSelectorItem
import com.mobven.fitai.util.enums.SignUpFragmentType
import com.mobven.fitai.util.enums.SignUpSelectorType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel
    @Inject
    constructor(
        private val stringRes: StringResourceProvider,
    ) : ViewModel() {
        private val _signUpState = MutableLiveData(SignUpState())
        val signUpState: LiveData<SignUpState> = _signUpState

        fun onAction(action: SignUpAction) {
            when (action) {
                is SignUpAction.GetSelectorItem -> {
                    getSignUpSelectorList(action.signUpFragmentType)
                }
            }
        }

        private fun getSignUpSelectorList(signUpFragmentType: SignUpFragmentType) {
            _signUpState.value =
                SignUpState(
                    signUpSelectorList =
                        when (signUpFragmentType) {
                            SignUpFragmentType.GENDER -> {
                                listOf(
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.other_gender),
                                        isSelected = false,
                                        type = SignUpSelectorType.RADIO,
                                        image = R.drawable.other_gender_icon,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.male_gender),
                                        isSelected = false,
                                        type = SignUpSelectorType.RADIO,
                                        image = R.drawable.male_icon,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.female_gender),
                                        isSelected = false,
                                        type = SignUpSelectorType.RADIO,
                                        image = R.drawable.female_icon,
                                    ),
                                )
                            }

                            SignUpFragmentType.GOALS -> {
                                listOf(
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.healthy_life),
                                        isSelected = false,
                                        type = SignUpSelectorType.RADIO,
                                        image = R.drawable.healthy_life,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.muscle_gain),
                                        isSelected = false,
                                        type = SignUpSelectorType.RADIO,
                                        image = R.drawable.increase_muscle,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.weight_gain),
                                        isSelected = false,
                                        type = SignUpSelectorType.RADIO,
                                        image = R.drawable.increase_weight,
                                    ),
                                    ListSelectorItem(
                                        title = stringRes.getString(R.string.weight_loss),
                                        isSelected = false,
                                        type = SignUpSelectorType.RADIO,
                                        image = R.drawable.weight_down,
                                    ),
                                )
                            }
                        },
                )
        }
    }

data class SignUpState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String = "",
    val signUpSelectorList: List<ListSelectorItem> = emptyList(),
) {
    companion object {
        fun initial() =
            SignUpState(
                isLoading = true,
            )
    }
}
