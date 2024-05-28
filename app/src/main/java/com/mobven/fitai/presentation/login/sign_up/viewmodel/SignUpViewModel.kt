package com.mobven.fitai.presentation.login.sign_up.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobven.fitai.R
import com.mobven.fitai.infrastructure.string_resource.StringResourceProvider
import com.mobven.fitai.presentation.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val stringRes: StringResourceProvider
): ViewModel() {

    private val _signUpState = MutableLiveData(SignUpState())
    val signUpState : LiveData<SignUpState> = _signUpState

    fun onAction(action: SignUpAction) {
        when(action) {
            is SignUpAction.GetSelectorItem -> {
                getSignUpSelectorList()
            }
        }
    }

    private fun getSignUpSelectorList(){
         _signUpState.postValue(
             SignUpState(
                 signUpSelectorList = listOf(
                     SignUpSelectorItem(
                         title = stringRes.getString(R.string.other_gender),
                         isSelected = false,
                         type = SignUpSelectorType.RADIO
                     ),
                     SignUpSelectorItem(
                         title = stringRes.getString(R.string.male_gender),
                         isSelected = false,
                         type = SignUpSelectorType.RADIO
                     ),
                     SignUpSelectorItem(
                         title = stringRes.getString(R.string.female_gender),
                         isSelected = false,
                         type = SignUpSelectorType.RADIO
                     )
                 )
             )
         )
    }

}

data class SignUpState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String = "",
    val signUpSelectorList: List<SignUpSelectorItem> = emptyList()
){

    companion object {
        fun initial() = SignUpState(
            isLoading = true,
        )
    }

}