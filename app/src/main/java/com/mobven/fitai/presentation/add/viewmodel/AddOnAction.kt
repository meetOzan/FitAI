package com.mobven.fitai.presentation.add.viewmodel

sealed class AddOnAction {
    data object GetTrainingItems : AddOnAction()
    data object GetFoodItems : AddOnAction()
}