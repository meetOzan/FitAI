package com.mobven.fitai.presentation.login.sign_up.viewmodel

import com.mobven.fitai.util.enums.SignUpFragmentType

sealed class SignUpAction {
    data class GetSelectorItem(
        val signUpFragmentType: SignUpFragmentType,
    ) : SignUpAction()
}
