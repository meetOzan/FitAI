package com.mobven.fitai.presentation.add.training

import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentAddTrainingBinding
import com.mobven.fitai.presentation.add.adapter.AddItemAdapter
import com.mobven.fitai.presentation.add.viewmodel.AddOnAction
import com.mobven.fitai.presentation.add.viewmodel.AddViewModel
import com.mobven.fitai.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTrainingFragment :
    BaseFragment<FragmentAddTrainingBinding>(FragmentAddTrainingBinding::inflate) {

    private val viewModel: AddViewModel by viewModels()
    private val adapter = AddItemAdapter(
        onTrainingItemClicked = {
            val bottomNavigation = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.bottom_sheet_add_training, null)
            bottomNavigation.setContentView(view)

            view.findViewById<ImageView>(R.id.iv_close_time_training).setOnClickListener {
                bottomNavigation.dismiss()
            }
            view.findViewById<Button>(R.id.btn_add_training_time).setOnClickListener {
                // TODO add training time
                bottomNavigation.dismiss()
            }

            bottomNavigation.show()
        }
    )

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