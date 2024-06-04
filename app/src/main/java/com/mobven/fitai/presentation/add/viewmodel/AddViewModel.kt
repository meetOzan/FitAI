package com.mobven.fitai.presentation.add.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobven.fitai.R
import com.mobven.fitai.presentation.add.adapter.AddItemModel
import com.mobven.fitai.presentation.add.food.FoodModel
import com.mobven.fitai.presentation.add.training.TrainingModel
import com.mobven.fitai.util.enums.SelectItemType
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
            is AddOnAction.AddSelectedFood -> addFoodItem(action.food)
            is AddOnAction.AddSelectedTraining -> addTrainingItem(action.training)
        }
    }

    private fun getTrainingItemList() {
        _uiState.value = _uiState.value?.copy(
            trainingItemList =
            listOf(
                AddItemModel("Yürüyüş", R.drawable.walking, "Düşük Tempo - 1 saatte 65 kcal", SelectItemType.TRAINING),
                AddItemModel("Koşu", R.drawable.running, "1 saatte 178 kcal", SelectItemType.TRAINING),
                AddItemModel("Bisiklet", R.drawable.biceyle, "1 saatte 178 kcal", SelectItemType.TRAINING),
                AddItemModel("Yüzme", R.drawable.swimming, "1 saatte 178 kcal", SelectItemType.TRAINING),
                AddItemModel("Tennis", R.drawable.tennis, "1 saatte 280 kcal", SelectItemType.TRAINING)
            ).toMutableList()
        )
    }

    private fun getFoodItemList() {
        _uiState.value = _uiState.value?.copy(
            foodItemList =
            listOf(
                AddItemModel("Haşlanmış Yumurta", R.drawable.food_egg, "2 tane, 180 kcal", SelectItemType.FOOD),
                AddItemModel("Avokado", R.drawable.food_avocado, "Yarım, 220 kcal", SelectItemType.FOOD),
                AddItemModel("Domates", R.drawable.food_tomato, "1 tane, 40 kcal", SelectItemType.FOOD),
                AddItemModel("Tambuğday Ekmeği", R.drawable.food_bread, "1 dilim, 75 kcal", SelectItemType.FOOD)
            ).toMutableList()
        )
    }

    private fun addTrainingItem(trainingModel: TrainingModel) {
        _uiState.value = _uiState.value?.copy(
            trainingSelectedList = _uiState.value?.trainingSelectedList?.apply {
                add(trainingModel)
            } ?: mutableListOf()
        )
    }

    private fun addFoodItem(foodModel: FoodModel) {
        _uiState.value = _uiState.value?.copy(
            foodSelectedList = _uiState.value?.foodSelectedList?.apply {
                add(foodModel)
            } ?: mutableListOf()
        )
    }

}

data class AddUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val trainingItemList: MutableList<AddItemModel> = mutableListOf(),
    val foodItemList: MutableList<AddItemModel> = mutableListOf(),
    val trainingSelectedList : MutableList<TrainingModel> = mutableListOf(),
    val foodSelectedList : MutableList<FoodModel> = mutableListOf(),
)