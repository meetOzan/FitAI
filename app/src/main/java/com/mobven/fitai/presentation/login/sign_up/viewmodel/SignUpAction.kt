package com.mobven.fitai.presentation.login.sign_up.viewmodel

sealed class SignUpAction {
    data object GetSelectorItem : SignUpAction()
}