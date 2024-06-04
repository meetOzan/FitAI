package com.mobven.fitai.presentation.add.training

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.databinding.FragmentAddTrainingBinding
import com.mobven.fitai.presentation.add.adapter.AddItemAdapter
import com.mobven.fitai.presentation.add.viewmodel.AddOnAction
import com.mobven.fitai.presentation.add.viewmodel.AddViewModel
import com.mobven.fitai.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTrainingFragment : BaseFragment<FragmentAddTrainingBinding>(FragmentAddTrainingBinding::inflate) {

    private val viewModel: AddViewModel by viewModels()
    private val adapter = AddItemAdapter()

    override fun observeUi() {
        adapter.submitList(viewModel.uiState.value?.trainingItemList)
        binding.recyclerViewAdd.adapter = adapter

        binding.ivCloseAddTraining.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun callInitialViewModelFunction() {
        viewModel.onAction(AddOnAction.GetTrainingItems)
    }
}