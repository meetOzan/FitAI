package com.mobven.fitai.presentation.add.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobven.fitai.R
import com.mobven.fitai.presentation.add.adapter.AddItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableLiveData(AddUiState())
    val uiState: LiveData<AddUiState> = _uiState

    fun onAction(action: AddOnAction) {
        when (action) {
            AddOnAction.GetTrainingItems -> getTrainingItemList()
            AddOnAction.GetFoodItems -> getFoodItemList()
        }
    }

    private fun getTrainingItemList() {
        _uiState.value = _uiState.value?.copy(
            trainingItemList =
            listOf(
                AddItemModel("Yürüyüş", R.drawable.walking, "Düşük Tempo - 1 saatte 65 kcal"),
                AddItemModel("Koşu", R.drawable.running, "1 saatte 178 kcal"),
                AddItemModel("Bisiklet", R.drawable.biceyle, "1 saatte 178 kcal"),
                AddItemModel("Yüzme", R.drawable.swimming, "1 saatte 178 kcal"),
                AddItemModel("Tennis", R.drawable.tennis, "1 saatte 280 kcal")
            ).toMutableList()
        )
    }

    private fun getFoodItemList() {
        _uiState.value = _uiState.value?.copy(
            foodItemList =
            listOf(
                AddItemModel("Haşlanmış Yumurta", R.drawable.food_egg, "2 tane, 180 kcal"),
                AddItemModel("Avokado", R.drawable.food_avocado, "Yarım, 220 kcal"),
                AddItemModel("Domates", R.drawable.food_tomato, "1 tane, 40 kcal"),
                AddItemModel("Tambuğday Ekmeği", R.drawable.food_bread, "1 dilim, 75 kcal")
            ).toMutableList()
        )
    }

}

data class AddUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val trainingItemList: MutableList<AddItemModel> = mutableListOf(),
    val foodItemList: MutableList<AddItemModel> = mutableListOf(),
)