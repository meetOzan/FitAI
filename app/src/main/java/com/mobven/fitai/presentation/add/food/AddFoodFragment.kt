package com.mobven.fitai.presentation.add.food

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.databinding.FragmentAddFoodBinding
import com.mobven.fitai.presentation.add.adapter.AddItemAdapter
import com.mobven.fitai.presentation.add.training.TrainingAdapter
import com.mobven.fitai.presentation.add.viewmodel.AddOnAction
import com.mobven.fitai.presentation.add.viewmodel.AddViewModel
import com.mobven.fitai.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFoodFragment : BaseFragment<FragmentAddFoodBinding>(FragmentAddFoodBinding::inflate) {

    private val viewModel: AddViewModel by viewModels()
    private val selectedFoodAdapter = FoodAdapter()

    @SuppressLint("NotifyDataSetChanged")
    private val adapter = AddItemAdapter(
        onFoodItemClicked = {
            viewModel.onAction(
                AddOnAction.AddSelectedFood(
                    FoodModel(
                        name = viewModel.uiState.value?.foodItemList?.get(it)?.title.toString(),
                        image = viewModel.uiState.value?.foodItemList?.get(it)?.image,
                        count = 1
                    )
                )
            )
            selectedFoodAdapter.submitList(viewModel.uiState.value?.foodSelectedList)
            selectedFoodAdapter.notifyDataSetChanged()
        }
    )

    override fun observeUi() {
        adapter.submitList(viewModel.uiState.value?.foodItemList)
        binding.recyclerViewAdd.adapter = adapter

        binding.ivCloseAddFood.setOnClickListener {
            findNavController().popBackStack()
        }

        val expandableLayout = binding.cardSelectedAiAddItems.llExpandableAiFood

        selectedFoodAdapter.submitList(viewModel.uiState.value?.foodSelectedList)
        binding.cardSelectedAiAddItems.rvSelectedAiFoodItems.adapter = selectedFoodAdapter

        binding.cardSelectedFoodItems.setOnClickListener {
            if (expandableLayout.visibility == View.GONE) {
                expandableLayout.visibility = View.VISIBLE
            } else {
                expandableLayout.visibility = View.GONE
            }
        }

        binding.cardSelectedFoodItems.background = null
    }

    override fun callInitialViewModelFunction() {
        viewModel.onAction(AddOnAction.GetFoodItems)
    }

}